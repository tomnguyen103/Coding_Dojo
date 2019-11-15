const mongoose = require('mongoose');

const Author = mongoose.model('Author');

module.exports={
    index(_req,res){
        Author.find()
        .then(authors => res.json({authors}))
    },

    create(req,res){
        Author.create(req.body)
        .then(author => res.json({author}))
        .catch(e => res.json({
            errors : e.errors
        }))
    },

    getById(req,res){
        Author.findById(req.params.id)
        .then(author => res.json({author}))
        .catch(e => res.json({
            errors : e
        }))
    },

    delete(req,res){
        Author.findByIdAndDelete(req.params.id)
        .then( () => res.json({status: success}))
        .catch( e=> res.json({errors: e.errors}))
    },
    update(req,res){
        Author.findByIdAndUpdate(req.params.id,{
            name: req.body.name,
            age: req.body.age,
        },
        {
            new: true,
            runValidators: true
        })
        .then(author => res.json({author}))
        .catch( e=>res.json({errors: e.errors}))
    }
}