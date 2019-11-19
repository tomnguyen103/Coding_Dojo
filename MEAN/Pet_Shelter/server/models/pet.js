const mongoose = require('mongoose');

const PetSchema = new mongoose.Schema({
    name: {
        type: String,
        required:[
            true,
            'Please enter pet name!',
        ],
        validate:[
            name => name && name.length > 2,
            "Please enter name at least 3 character long."
        ]
    },
    type: {
        type: String,
        required:[
            true,
            'Please enter the type of the pet!',
        ],
        validate:[
            type => type && type.length > 2,
            "Please enter type at least 3 character long."
        ]
    },
    description: {
        type: String,
        required:[
            true,
            'Please enter the description of the pet!',
        ],
        validate:[
            type => type && type.length > 2,
            "Please enter pet description at least 3 character long."
        ]
    },
    skill1: {
        type: String,
    },
    skill2: {
        type: String,
    },
    skill3: {
        type: String,
    },
    like:{
        type: Number,
        default: 0
    }
    
}, {timestamps: true});


//register model
mongoose.model('Pet', PetSchema);