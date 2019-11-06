const express = require('express');
const mongoose = require('mongoose');

const app = express();

mongoose.connect('mongodb://localhost/lectures',{
    useNewUrlParser: true,
    useUnifiedTopology: true
})

const DojoSchema = new mongoose.Schema({
    location: {
        type: String,
        required: [
            true,
            'Please enter location'
        ]
    },
    capacity:{
        type: Number,
        required: [
            true,
            'Please enter a capacity!'
        ]
    }
}, {timestamps: true});

const Dojo = mongoose.model('Dojo', DojoSchema);

// const Dojo = mongoose.model('Dojo');

app.use(express.static(__dirname+'/static'));

app.use(express.urlencoded({ extended: true}));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));

app.get('/',(req,res)=>{
    Dojo.find()
        .then(dojos => res.render('index',{
            dojos
        }))
        .catch(console.log)
});

app.post('/dojos',(req,res)=>{
    Dojo.create(req.body)
    .then(console.log)
    .catch(console.log)
    .finally(()=>{
        res.redirect('/')
    })
});

app.get('/dojos/:id/delete', (req,res)=>{
    Dojo.findByIdAndDelete(req.params.id)
    .then( ()=> res.redirect('/'));
});

app.listen(4500,()=> console.log('Listening on port 4500'))

