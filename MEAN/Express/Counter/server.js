const express = require('express');
const session = require('express-session');

const app = express();

app.use(express.static(__dirname+'/static'));

app.use(session({
    secret: 'somethinghere',
    resave: false,
    saveUninitialized: true,
    cookie: {maxAge: 60000},
}))

app.use(express.urlencoded({extended: true}));


app.set('view engine', 'ejs');
app.set('views', __dirname+'/views');

app.get('/',(req,res)=> {
    if(req.session.visit === undefined){
        req.session.visit = 0;
    }
    req.session.visit += 1;
    // console.log(count);
    res.render('index', {count : req.session.visit});
})


// app.post('/process-time',(req,res)=>{
//     // console.log("this is the body "+req.body);
//     req.session = req.body;
//     res.redirect('/');
// })

app.post('/reset', (req,res)=>{
    req.session.visit = 0;
    res.redirect('/');
});

app.post('/add2', (req,res)=>{
    req.session.visit += 1;
    res.redirect('/');
})

app.listen(3000,()=> console.log('listening on port 3000'))