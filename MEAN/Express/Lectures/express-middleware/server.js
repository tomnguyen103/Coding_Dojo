const express = require('express');
const fs = require('fs');
const session = require('express-session');

const app = express();

app.set('view engine', 'ejs');
app.set('views', __dirname+'/views');

app.use((req,res, next) => {
    const path = __dirname + '/static' + req.path;
    fs.readFile(path, (err,data)=>{
        if(err){
            return next();
        }
        res.sendFile(path);
    });
});


app.use(session({
    secret: 'keyboard cat',
    resave: false,
    saveUninitialized: true,
    cookie: {maxAge:6000}
}))

app.post('/process-name',(req,res)=>{
    // console.log("this is the body "+req.body);
    req.session.name = req.body.name;
    // res.redirect('/');
})

app.get('/',(req,res)=> {
    res.render('index');
    req.session.name;
});

app.all('*', (_req,res) => res.render('404page'))

app.listen(3300, ()=> console.log("listening on port 3300"));
