const express = require('express');

const app = express();

app.use(express.static(__dirname+'/static'));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));

const server = app.listen(3000,()=> console.log('Listening on port 3000'));


const io = require('socket.io')(server);

app.get('/',(_req,res)=>{
    user = res.user;
    res.render('index',{user});
})

var users = [];
var messages = [];

//check if the user is registered yet
var is_user = function(user){
    var user_count = users.length;
    for(var i=0;i<user_count;i++){
        if(users[i]==user){
            return true;
        }
    }
    return false;
}

io.on('connection',socket =>{
    socket.on('new_user', data =>{
        if(is_user(data.user)==true){
            socket.emit('existing_user',{error: "This user already registered!"});
        }
        else{
            users.push(data.user);
            socket.emit('load_messages',{current_user: data.user, messages: messages});
        }
    });
    socket.on("new_message",data =>{
        console.log(data);
        messages.push({user: data.user, message: data.message});
        console.log(data.message);
        io.emit("post_new_message", {new_message: data.message, user: data.user});
    });
});

