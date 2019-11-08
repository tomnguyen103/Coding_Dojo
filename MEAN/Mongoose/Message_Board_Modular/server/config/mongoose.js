const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/message_board_modular',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false,
})

require('../models/message');