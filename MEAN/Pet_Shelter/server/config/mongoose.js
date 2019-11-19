const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/pets',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false
})

require('../models/pet');