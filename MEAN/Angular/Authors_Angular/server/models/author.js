const mongoose = require('mongoose');

const AuthorSchema = new mongoose.Schema({
    name: {
        type: String,
        required:[
            true,
            'Please enter the name!',
        ]
    },
    age:{
        type: Number,
        required: [
            true,
            'Please enter the age!',
        ],
        validate:[
            age => age && age > 9,
            "Please enter age greater than 9."
        ]
    }
}, {timestamps: true})

//register model
mongoose.model('Author', AuthorSchema);