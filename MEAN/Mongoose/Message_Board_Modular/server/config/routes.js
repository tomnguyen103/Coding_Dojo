const messagesControler = require('../controllers/messages');


module.exports = app =>{
    app.get('/',messagesControler.index);
    app.post('/messages', messagesControler.create);
    app.post('/messages/:id/comments', messagesControler.createComment);
}