const express = require('express');

const port = 3444;

const app = express();

// app.use(express.static(__dirname+'/static'));
// app.use(express.urlencoded({ extended: true}));
app.use(express.json());

require('./server/config/mongoose');
require('./server/config/routes')(app);

app.listen(port,()=> console.log('Listening on port '+ port));
