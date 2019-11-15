const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema({
    title:{
        type: String,
        required:[
            true,
            "Please enter the product title!",
        ],
        validate:[
            title => title && title.length > 3,
            "Please enter the product title minimum 4 characters!",
        ]
    },
    price:{
        type: Number,
        required:[
            true,
            "Please enter the product price!",
        ],
        validate:[
            price => price && price > 0,
            "Please enter the valid number for price "
        ]
    },
    img_url:{
        type: String,
    }
},{timestamps: true})

//register model
mongoose.model('Product', ProductSchema)