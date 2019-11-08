const mongoose = require('mongoose');

const Quote = mongoose.model('Quote');

module.exports = {
    index(req,res){
        Quote.find()
        .then( () => res.render('index'))
    },
    getQuotes(req,res){
        Quote.find()
        .then(quotes => res.render('quotes',{
            quotes
        }))
        .catch(console.log)
    },
    postQuotes(req,res){
        Quote.create(req.body)
        .then(console.log)
        .catch(console.log)
        .finally(()=>{
            res.render('quotes',{quotes: quotes})
        })
    }
}