const mongoose = require('mongoose');

const Pet = mongoose.model('Pet');

module.exports = {
    index(_req,res){
        Pet.find()
        .then( pets => res.json({pets}))
    },

    create(req,res){
        Pet.create(req.body)
        .then( pet => res.json({pet}))
        .catch(e => res.json({
            errors: e.errors
        }))
    },

    getById(req,res){
        Pet.findById(req.params.id)
        .then(pet => res.json({pet}))
        .catch(e=> res.json({errors: e.errors}))
    },

    delete(req,res){
        Pet.findByIdAndDelete(req.params.id)
        .then( ()=> res.json({status: success}))
        .catch( e=> res.json({errors: e.errors}))
    },

    update(req,res){
        Pet.findByIdAndUpdate(req.params.id, {
            name: req.body.name,
            type: req.body.type,
            description: req.body.description,
            skill1: req.body.skill1,
            skill2: req.body.skill2,
            skill3: req.body.skill3,
        },
        {
            new: true,
            runValidators: true
        })
        .then(pet => res.json({pet}))
        .catch( e=> res.json({errors: e.errors}))
    }
}