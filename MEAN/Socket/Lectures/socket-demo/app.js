const express = require('express');

const app = express();

app.use(express.static(__dirname+ '/static'));

app.use('/socket.io.js',(_req,res)=>{
    res.sendFile(__dirname+'/node_modules/socket.io-client/dist/socket.io.js');
});

const server = app.listen(3900);

const io = require('socket.io')(server);

let count = 0;

io.on('connection', socket =>{

    // console.log(socket);

    count++;
    console.log('We have ' + count + ' connection currently.')
    io.emit('new user', {
        id:count
    });
    socket.emit('welcome', {
        message: 'Welcome to my app!',
    });
    socket.broadcast.emit('broadcast', {
        message: "Some new user just joined! It's not you",
    });

    socket.on('disconnect', ()=> count--)
});