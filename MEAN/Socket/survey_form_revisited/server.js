const express = require('express');
const session = require('express-session');
const fs = require('fs');

const app = express();

app.use(express.static(__dirname+'/static'));

app.use(session({
    secret: "somesecretkeyhere",
}));

app.set('view engine', 'ejs');
app.set('views', __dirname+'/views');

app.use(express.urlencoded({extended: true}));

// app.get('/',(req,res)=>{
//     if(req.session.visit === undefined){
//         req.session.visit = 1;
//     }
//     req.session.visit += 1;
//     res.render('index');
// })

// app.post('/result',(req,res)=>{
//     req.session.name = req.body.name;
//     req.session.location = req.body.location;
//     req.session.fav_language = req.body.fav_language;
//     req.session.comment = req.body.comment;

//     res.render('result',{
//         visit: req.session.visit,
//         name: req.session.name,
//         location: req.session.location,
//         fav_language: req.session.fav_language,
//         comment: req.session.comment,
//     });
// })

const server = app.listen(3000, ()=> console.log('Listening on port 3000'));

const io = require('socket.io')(server);

app.get('/', (_req,res)=>{
    res.render('index');
});

io.on("connection", socket=>{
    socket.on('posting_form', data =>{
        var random_number= Math.floor((Math.random()*1000)+1);
        // console.log(random_number);

        socket.emit('updated_message', {response: data});
        socket.emit('random_number', {response: random_number});
    });
});