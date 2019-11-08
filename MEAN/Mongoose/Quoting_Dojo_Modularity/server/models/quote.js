const mongoose = require('mongoose');

const QuoteSchema = new mongoose.Schema({
    name:{
        type: String,
        required: [
            true,
            'Please enter your name!',
        ]
    },
    quote:{
        type: String,
        required: [
            true,
            'Please enter your quote!',
        ]
    }
},{timestamps: true});

mongoose.model('Quote', QuoteSchema);