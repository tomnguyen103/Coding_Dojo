const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/1955_Api',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
})

require('../models/name');
