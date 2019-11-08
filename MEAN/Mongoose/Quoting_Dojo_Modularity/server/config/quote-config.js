const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/quote_modular',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
})

require('../models/quote');