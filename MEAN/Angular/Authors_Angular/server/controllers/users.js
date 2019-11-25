const mongoose = require('mongoose');

const bcrypt = require('bcrypt');



const User = mongoose.model('User');

module.exports={
    register(req,res){
        bcrypt.hash(req.body.password, 8)
        .then( hashedpw => {
            User.create({
                firstName: req.body.first,
                lastName: req.body.last,
                email: req.body.email,
                password: hashedpw
            })
            .then(user => {
                req.session.userId = user._id,
                res.json({user:{
                    first: user.firstName,
                    last: user.lastName
                }})
            
            })
            .catch(e =>res.json({errors: e}))
        })
    },

    login(req,res){
        User.findOne({email: req.body.email})
        .then(result => {
            if(result){


                bcrypt.compare(req.body.password, user.password)
                .then(()=> {
                    req.session.userId = user._id;
                    res.json({status: "success"})
                })
            }else{
                res.json({status: 'failed'})
            }
        })
        .catch(e => res.json({errors: e}));
    },

    logout(req,res){
        req.session.destroy();
        res.json({status: "Logout Successfully!"})
    },

    getCurrentUser(req,res){
        const userId = req.session.userId;
        if(userId){
            User.findById(userId)
            .then(user => res.json({ user:{
                first: user.firstName,
                last: user.lastName,
                email: user.email
            } }))
        }else{
            res.json({user: null})
        }
    }
}