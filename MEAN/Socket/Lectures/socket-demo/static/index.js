document.addEventListener('DOMContentLoaded',()=>{
    const socket = io();
    
    socket.on('new user', data =>{
        console.log(data);
    });
    socket.on('welcome', console.log);
    socket.on('broadcast', console.log)
});