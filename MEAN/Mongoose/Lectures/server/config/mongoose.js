const mongoose = require('mongoose');
const fs = require('fs');

mongoose.connect('mongodb://localhost/lectures',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
})

// require('../models/dojo');

const modelsPath = __dirname+ '/../models';

fs.readdirSync(modelsPath).forEach(fileName =>{
    require(modelsPath + '/' + fileName);
})