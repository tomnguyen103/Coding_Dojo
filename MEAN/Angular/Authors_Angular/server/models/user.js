const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
    firstName: {
        type: String,
        required:[
            true,
            "Please enter your first name!"
        ]
    },
    lastName: {
        type: String,
        required:[
            true,
            "Please enter your last name!"
        ]
    },
    email: {
        type: String,
        required:[
            true,
            "Please enter your email!"
        ],
        unique: true,
    },
    password:{
        type: String,
        required:[
            true,
            "Please Enter your password!"
        ]
    }
}, {timestamps: true});

mongoose.model('User',UserSchema);