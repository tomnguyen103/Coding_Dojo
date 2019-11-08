const mongoose = require('mongoose');

const NameSchema = new mongoose.Schema({
    name:{
        type: String,
        required:[
            true,
            "Please enter the name!",
        ]
    }
},{timestamps: true});

mongoose.model('Name', NameSchema);