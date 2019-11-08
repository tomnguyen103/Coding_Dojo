const mongoose = require('mongoose');

const MessageSchema = new mongoose.Schema({
    name: {
        type: String,
        required:[
            true,
            'Please enter your name!',
        ],
    },
    content: {
        type: String,
        required:[
            true,
            "Please enter a message!",
        ]
    },
    comments: [{
        name: {
            type: String,
            required:[
                true,
                "Please enter your name",
            ]
        },
        content: {
            type: String,
            required:[
                true,
                "Please enter a comment!",
            ]
        },
    }]
},{timestamps: true});

mongoose.model('Message', MessageSchema);