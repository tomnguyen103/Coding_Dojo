const express = require('express');

const port = 3444;

const app = express();

// app.use(express.static(__dirname+'/static'));
app.use(express.static( __dirname + '/public/dist/public' ));

app.listen(port,()=> console.log('Listening on port '+ port));
