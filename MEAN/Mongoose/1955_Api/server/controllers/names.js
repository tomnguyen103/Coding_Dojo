const mongoose = require('mongoose');
const Name = mongoose.model('Name');

module.exports= {
    index(_req,res){
        Name.find()
        .then( names => res.json({names}))
        .catch(err => res.json({error: err}))
    },
    newName(req,res){
        Name.create(req.params)
        .then( () => {
            Name.find()
            .then(name => res.json({name}))
        })
        .catch(err => res.json({error: err}))
    },
    removeName(req,res){
        Name.findOneAndRemove(req.params)
        .then( () => {
            Name.find()
            .then(name=> res.json({name}))
        })
        .catch(err => res.json({error: err}))
    },
    singleName(req,res){
        Name.findOne(req.params)
        .then( name => res.json({name}))
    }
}