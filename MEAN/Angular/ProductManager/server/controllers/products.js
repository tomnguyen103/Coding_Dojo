const mongoose = require('mongoose');

const Product = mongoose.model('Product');

// export module 

module.exports={
    index(_req,res){
        Product.find()
        .then(products => res.json({products}))
    },
    create(req,res){
        Product.create(req.body)
        .then(product => res.json({product}))
        .catch(e => res.json({
            errors: e.errors
        }))
    },

    getById(req,res){
        Product.findById(req.params.id)
        .then(product => res.json({product}))
        .catch(e => res.json({
            errors : e.errors
        }))
    },

    delete(req,res){
        Product.findByIdAndDelete(req.params.id)
        .then( ()=> res.json({status: success}))
        .catch( e => res.json({errors: e.errors}))
    },

    update(req,res){
        Product.findByIdAndUpdate(req.params.id,{
            title: req.body.title,
            price: req.body.price,
            img_url: req.body.img_url,
        },
        {
            new: true,
            runValidators: true
        })
        .then(product => res.json({product}))
        .catch( e=> res.json({errors: e.errors}))
    }
}