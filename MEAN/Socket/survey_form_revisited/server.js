const express = require('express');
const session = require('express-session');

const app = express();

app.use(session({secret: "somesecretkey"}));

app.set('view engine', 'ejs');
app.set('views', __dirname+'/views');
app.use(express.urlencoded({extended: true}));

app.use(express.static(__dirname+'/public'));

app.get('/',(req,res)=> {
    if(req.session.visit === undefined){
        req.session.visit = 1;
    }
    req.session.visit += 1;
    res.render('index')
});

app.post('/result',(req,res)=>{
    req.session.name = req.body.name;
    req.session.location = req.body.location;
    req.session.fav_language = req.body.fav_language;
    req.session.comment = req.body.comment;

    res.render('result', {
        visit: req.session.visit,
        name: req.session.name,
        location: req.session.location,
        fav_language: req.session.fav_language,
        comment: req.session.comment,
    });
});

app.listen(3000,()=> console.log('Listening port 3000'));

// const io = require('socket.io')(server);