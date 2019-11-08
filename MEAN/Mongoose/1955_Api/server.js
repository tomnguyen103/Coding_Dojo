const express = require('express');

const port = 3434;

const app = express();

app.use(express.json());

require('./server/config/mongoose');
require('./server/config/routes')(app);

app.listen(port,()=> console.log('Listening on port '+ port));