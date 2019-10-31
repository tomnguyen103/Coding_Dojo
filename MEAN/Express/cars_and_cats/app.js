const express = require('express');
const app = express();

app.use(express.static(__dirname + '/static/'));

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', (_req,res)=>{
    res.render('index');
})
app.get('/cars', (_req,res)=>{
    res.render('cars');
})
app.get('/cats', (_req,res)=>{
    res.render('cats');
})
app.get('/cuddles',(_req,res)=>{
    res.render('cuddles', {
        cuddles:
            {
                name: "Cuddles",
                fav_food: "Spaghetti",
                age: "3",
                sleeping_spot: ["under the bed", "in the sun"],
            }
        
    });
})
app.get('/black-cat',(_req,res)=>{
    res.render('black_cat', {
        black_cat:{
            name: "Black Cat",
            fav_food: "cat food",
            age: "3",
            sleeping_spot: "under the shadow",
        }
    });
})
app.get('/red-cat',(_req,res)=>{
    res.render('red_cat', {
        red_cat:
            {
                name: "Red Cat",
                fav_food: "fish",
                age: "6",
                sleeping_spot: ["under the chair", "beside Mom"],
            }
        
    });
})

app.get('/form', (_req,res)=>{
    res.render('form');
})

app.listen(8000,()=> console.log("Listening on port 800"));