const mongoose = require('mongoose');
const Task = mongoose.model('Task');

module.exports = {
    index(_req,res){
        Task.find()
        .then(tasks => res.json({ tasks }))
        .catch(err => res.json({error: err}))
    },
    create(req,res){
        Task.create(req.body)
        .then(task => res.json({task}))
        .catch(err => res.json({error:err}))
    },
    getById(req,res){
        Task.findById(req.prams.id)
        .then(task => res.json({task}))
        .catch(err => res.json({error:err}))
    },
    delete(req,res){
        Task.findByIdAndDelete(req.params.id)
        .then( ()=> res.json({status : 'success'}))
    },
    update(req,res){
        Task.findByIdAndUpdate(req.params.id,{
            title: req.body.title,
            description: req.body.description,
            completed: req.body.delete,
        },
        {
            new: true,
            runValidators: true,
        })
        .then(task => res.json({task}))
        .catch(err => res.json({error:err}))
    }
}