const express = require('express');

const port = 3444;

const app = express();

// app.use(express.static(__dirname+'/static'));
// app.use(express.urlencoded({ extended: true}));
app.use(express.json());
app.use(express.static( __dirname + '/public/dist/public' ));


require('./server/config/mongoose');
require('./server/config/routes')(app);

app.all('*',(_req,res)=> res.sendFile(__dirname+'/public/dist/public/index.html'));

app.listen(port,()=> console.log('Listening on port '+ port));
