const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/products',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false
})

//require the model
require('../models/product');