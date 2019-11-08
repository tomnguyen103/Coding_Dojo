const express = require('express');
const mongoose = require('mongoose');

const app = express();



app.set('view engine', 'ejs');

app.set('views',__dirname+'/client/views');

app.use(express.urlencoded({extended: true}));

app.use(express.static(__dirname+'/client/static'));

app.listen(1223,()=> console.log('Listening on port 1223'));

require('./server/config/mongoose');
require('./server/config/routes')(app);
