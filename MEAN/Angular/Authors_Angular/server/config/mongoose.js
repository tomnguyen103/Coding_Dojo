const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/authors',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
    useCreateIndex: true
})

require('../models/author');
require('../models/user');