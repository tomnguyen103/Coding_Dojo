const express = require('express');
const mongoose = require('mongoose');

const port = 3444;

const app = express();

mongoose.connect('mongodb://localhost/message_board',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
});
var Schema = mongoose.Schema;



const CommentSchema = new mongoose.Schema({
    comment_name: {
        type: String,
        required: [
            true,
            'Please Enter Your Comment_Name!',
        ]
    },
    comment: {
        type: String,
        required:[
            true,
            'Please Enter Your Comment!',
        ],
    },
}, {timestamps: true});

const MessageSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            'Please Enter Your Name!',
        ],
    },
    message: {
        type: String,
        required:[
            true,
            'Please Enter Your Message!',
        ]
    },
    comments: [CommentSchema],
}, {timestamps: true});

const Message = mongoose.model('Message', MessageSchema);
const Comment = mongoose.model('Comment', CommentSchema);

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));

app.use(express.static(__dirname+'/static'));

app.listen(port,()=> console.log('Listening on port '+ port));


app.get('/',(req,res)=>{
    Message.find()
    .then(messages => {
        console.log(messages);
        res.render('index',{
        messages
        
    })})
    .catch(console.log);
})

app.post('/add-message',(req,res)=>{
    Message.create(req.body)
    .then(console.log)
    .catch(console.log)
    .finally(()=>{
        res.redirect('/')
    })
})
app.post('/add-comment/:id',(req,res)=>{
    Comment.create({comment_name: req.body.comment_name, comment: req.body.comment})
    .then(comment => Message.findByIdAndUpdate(
        {_id: req.params.id},
        {
            $push:{
                comments:comment
            }
        },
        {
            new: true,
            runValidators: true,
        }))
    .catch(console.log)
    .finally(()=>{
        res.redirect('/')
    })
})

app.get('/delete-message/:id',(req,res)=>{
    Message.findByIdAndDelete(req.params.id)
    .then( ()=>{
        res.redirect('/')
    })
})
app.get('/delete-comment/:id',(req,res)=>{
    Comment.findByIdAndDelete(req.params.id)
    .then( ()=>{
        res.redirect('/')
    })
})