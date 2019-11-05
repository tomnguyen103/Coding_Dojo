const express = require('express');

const app = express();

app.use(express.static(__dirname+'/static'));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));


const server = app.listen(3000,()=> console.log('Listening on port 3000'));

const io = require('socket.io')(server);

var color = "";

io.on('connect',socket =>{
    socket.emit('start',{
        bgc: color
    });
    socket.broadcast.emit('start',{
        bgc: color
    });
    socket.on("green_pressed",function(){
        socket.emit("green_color");
        socket.broadcast.emit("green_color");
        color = "green";
    })
    socket.on("blue_pressed",function(){
        socket.emit("blue_color");
        socket.broadcast.emit("blue_color");
        color = "blue";
    })
    socket.on("pink_pressed",function(){
        socket.emit("pink_color");
        socket.broadcast.emit("pink_color");
        color = "pink";
    })
})

app.get('/',(_req,res)=>{
    res.render('index');
})

