const mongoose = require('mongoose');

const Message = mongoose.model('Message');

module.exports = {
    index(_req,res) {
        Message.find()
        .then(messages => {
            res.render('index',{ messages })
        })
        .catch(console.log)
    },
    create(req,res){
        Message.create(req.body)
        .catch(console.log)
        .finally(()=> {
            res.redirect('/')
        })
    },
    createComment(req,res){
        Message.findByIdAndUpdate(
            req.params.id,
            {
                $push:{
                    comments: req.body
                }
            },
            {
                new: true,
                runValidator: true,
            },
        )
        .catch(console.log)
        .finally(()=> res.redirect('/'))
    }

}