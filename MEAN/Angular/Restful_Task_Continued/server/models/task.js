const mongoose = require('mongoose');

const TaskSchema = new mongoose.Schema({
    title: {
        type: String,
        required: [
            true,
            'please enter title'
        ]
    },
    description: {
        type: String,
        required: [
            true,
            'please enter description'
        ]
    },
    completed:{
        type: Boolean,
        default: false,
    }
},{timestamps: true});

mongoose.model('Task', TaskSchema);