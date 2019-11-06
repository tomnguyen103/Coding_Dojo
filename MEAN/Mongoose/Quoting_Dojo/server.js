const express = require('express');
const mongoose = require('mongoose');

const app = express();

mongoose.connect('mongodb://localhost/quoting_dojo',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

const QuoteSchema = new mongoose.Schema({
    name:{
        type: String,
        required: [
            true,
            'Please enter your name!',
        ]
    },
    quote:{
        type: String,
        required: [
            true,
            'Please enter your quote!',
        ]
    }
},{timestamps: true});

const Quote = mongoose.model('Quote', QuoteSchema);

app.use(express.static(__dirname+'/static'));

app.use(express.urlencoded({ extended: true}));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/views');

app.use(express.urlencoded({extended: true}));


app.listen(1223,()=> console.log('Listening on port 1223'));

app.get('/',(req,res)=>{
    // Quote.create(req.body)
    // .then(console.log)
    // .catch(console.log)
    // .finally( ()=>{
    //     res.render('index')
    // })
    res.render('index');
});

app.get('/quotes',(req,res)=>{
    Quote.find()
    .then(quotes => res.render('quotes',{
        quotes
    }))
    .catch(console.log)
})

app.post('/quotes',(req,res)=>{
    Quote.create(req.body)
    .then(console.log)
    .catch(console.log)
    .finally(()=>{
        res.render('quotes',{quotes: quotes})
    })
})

