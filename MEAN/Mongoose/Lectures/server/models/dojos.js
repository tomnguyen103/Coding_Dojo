const mongoose = require('mongoose'); 

const DojoSchema = new mongoose.Schema({
    location: {
        type: String,
        required: [
            true,
            'Please enter location!',
        ]
    },
    capacity:{
        type: Number,
        required: [
            true,
            'Please enter a capacity!',
        ]
    }
}, {timestamps: true});

mongoose.model('Dojo', DojoSchema);