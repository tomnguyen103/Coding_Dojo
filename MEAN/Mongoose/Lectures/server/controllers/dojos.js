const mongoose = require('mongoose');

const Dojo = mongoose.model('Dojo');

module.exports = {
    index : (_req,res)=>{
        Dojo.find()
            .then(dojos => res.render('index',{
                dojos
            }))
            .catch(console.log)
    },
    create: (req,res)=>{
        Dojo.create(req.body)
        .then(console.log)
        .catch(console.log)
        .finally(()=>{
            res.redirect('/')
        })
    },
    // delete: (req,res)=>{
    //     Dojo.findByIdAndDelete(req.params.id)
    //     .then( ()=> res.redirect('/'));
    // }

}