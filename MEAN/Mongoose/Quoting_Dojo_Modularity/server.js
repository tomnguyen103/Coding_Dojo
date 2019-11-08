const express = require('express');
const mongoose = require('mongoose');

const app = express();

mongoose.connect('mongodb://localhost/quoting_dojo',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

app.use(express.static(__dirname+'/client/static'));

app.use(express.urlencoded({ extended: true}));

app.set('view engine', 'ejs');

app.set('views',__dirname+'/client/views');

app.use(express.urlencoded({extended: true}));


app.listen(1222,()=> console.log('Listening on port 1222'));

require('./server/config/quote-config');
require('./server/config/routes')(app);
