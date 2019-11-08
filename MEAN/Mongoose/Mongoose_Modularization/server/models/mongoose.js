const mongoose = require('mongoose');

const AnimalSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            'Please enter the name of the animal!',
        ],
    },
    description:{
        type: String,
        required:[
            true,
            'Please enter the description!',
        ],
    }
}, {timestamps: true});

mongoose.model('Animal', AnimalSchema);