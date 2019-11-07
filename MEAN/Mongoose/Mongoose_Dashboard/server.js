const express = require('express');
const mongoose = require('mongoose');

const app = express();

mongoose.connect('mongodb://localhost/mongoose_dashboard',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

const AnimalSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            'Please enter the name of the animal!',
        ],
    },
    description:{
        type: String,
        required:[
            true,
            'Please enter the description!',
        ],
    }
}, {timestamps: true});

const Animal = mongoose.model('Animal', AnimalSchema);

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));

app.use(express.static(__dirname+'/static'));

app.listen(1223,()=> console.log('Listening on port 1223'));

app.get('/', (req,res)=>{
    Animal.find()
    .then(animals => res.render('index',{
        animals
    }))
    .catch(console.log)
})



app.get('/new',(req,res)=>{
    res.render('new')
})

app.post('/animal',(req,res)=>{
    Animal.create(req.body)
    .then(console.log)
    .catch(console.log)
    .finally(()=>{
        res.redirect('/')
    })
})

app.get('/delete/:id',(req,res)=>{
    Animal.findByIdAndDelete(req.params.id)
    .then( ()=>{
        res.redirect('/')
    })
})

app.get('/edit/:id',(req,res)=>{
    Animal.findById(req.params.id)
    .then(animal =>{
        res.render('edit',{id: animal._id})
    })
})

app.get('/animal/:id',(req,res)=>{
    Animal.findById(req.params.id)
    .then(animal => res.render('animal',{animal}))
})

app.post('/animal/:id',(req,res)=>{
    Animal.findByIdAndUpdate(req.params.id,{
        name: req.body.name,
        description: req.body.description,
    },()=>{console.log})
    .then( animal =>{res.render('animal',{animal})})
    .catch(console.log)
})