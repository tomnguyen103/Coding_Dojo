const express = require('express');

const app = express();

app.use(express.static(__dirname+'/static'));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));

const server = app.listen(3000,()=> console.log('Listening on port 3000'));

const io = require('socket.io')(server)

app.get('/',(_req,res)=>{
    res.render('index');
})
let count = 0;
io.on("connect",socket=>{
    socket.on('button_clicked',data =>{
        count++;
        io.emit("update_count", {count: count});
    });
    socket.on('reset_clicked', data => {
        count = 0;
        io.emit("update_count", {count: count});
    });
});