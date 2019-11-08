const mongoose = require('mongoose');

const Animal = mongoose.model('Animal');

module.exports = {
    index(req,res){
        Animal.find()
        .then(animals => res.render('index',{
            animals
        }))
        .catch(console.log)
    },
    new(req,res){
        res.render('new')
    },
    addAnimal(req,res){
        Animal.create(req.body)
        .then(console.log)
        .catch(console.log)
        .finally(()=>{
            res.redirect('/')
        })
    },
    delete(req,res){
        Animal.findByIdAndDelete(req.params.id)
        .then( ()=>{
            res.redirect('/')
        })
    },
    edit(req,res){
        Animal.findById(req.params.id)
        .then(animal =>{
            res.render('edit',{id: animal._id})
        })
    },
    show1(req,res){
        Animal.findById(req.params.id)
        .then(animal => res.render('animal',{animal}))
    },
    show2(req,res){
        Animal.findByIdAndUpdate(req.params.id,{
            name: req.body.name,
            description: req.body.description,
        },()=>{console.log})
        .then( animal =>{res.render('animal',{animal})})
        .catch(console.log)
    }
}