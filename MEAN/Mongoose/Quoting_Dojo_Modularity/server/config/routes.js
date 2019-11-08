const quoteController = require('../controllers/quotes');

module.exports = app=> {
app.get('/',quoteController.index);

app.get('/quotes',quoteController.getQuotes);

app.post('/quotes',quoteController.postQuotes);
}