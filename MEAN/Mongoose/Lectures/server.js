const express = require('express');

const app = express();

app.use(express.static(__dirname + '/client/static'));

app.use(express.urlencoded({ extended: true}));

app.set('view engine', 'ejs');
app.set('views',__dirname + '/client/views');

require('./server/config/mongoose');
require('./server/config/routes')(app);

app.listen(4000,()=> console.log('Listening on port 4000'))

