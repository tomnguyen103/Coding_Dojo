const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/mongoose_modularization',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
});

require('../models/mongoose');