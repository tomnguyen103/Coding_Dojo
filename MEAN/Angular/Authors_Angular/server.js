const express = require('express');

const session = require('express-session');


const port = 3444;

const app = express();

app.use(session({
    secret: 'some secret sentences',
    resave: false,
    saveUninitialized: true,
    // cookie: { secure: true }
}));

app.use(express.json());

app.use(express.static(__dirname + '/public/dist/public'));


require('./server/config/mongoose');
require('./server/config/routes')(app);

app.all('*',(req,res)=> res.sendFile(__dirname + '/public/dist/public/index.html'));

app.listen(port,()=> console.log('Listening on port '+ port));
