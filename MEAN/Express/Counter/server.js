const express = require('express');
const session = require('express-session');

const app = express();
var count = 0;

app.use(express.static(__dirname+'/static'));

app.use(session({
    secret: 'somethinghere',
    // resave: false,
    // saveUninitialized: true,
    // cookie: {maxAge: 60000},
}))

app.set('view engine', 'ejs');
app.set('views', __dirname+'/views');

app.get('/',(req,res)=> {
    count++;
    console.log(count)
    res.render('index', (req,res)=> {count: count})
    });

app.post('/process-name',(req,res)=>{
    // console.log("this is the body "+req.body);
    req.session.name = req.body.name;
    res.redirect('/');
})

app.listen(3000,()=> console.log('listening on port 3000'))