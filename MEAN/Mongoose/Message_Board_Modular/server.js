const express = require('express');

const port = 4900;

const app = express();
app.set('view engine', 'ejs');

app.set('views',__dirname+'/client/views');

app.use(express.urlencoded({extended: true}));

app.use(express.static(__dirname+'/client/static'));


require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);

app.listen(port,()=> console.log('Listening on port '+ port));
