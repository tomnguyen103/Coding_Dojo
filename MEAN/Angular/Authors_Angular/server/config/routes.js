const authorsCtl = require('../controllers/authors');

const usersCtl = require('../controllers/users');

module.exports = app => {
    app.post('/api/users', usersCtl.register);
    app.post('/api/users/login', usersCtl.login);
    app.delete('/api/users/logout', usersCtl.logout);
    app.get('/api/users/current', usersCtl.getCurrentUser);
    
    app.get('/api/authors', authorsCtl.index);
    app.post('/api/authors', authorsCtl.create);
    app.get('/api/authors/:id', authorsCtl.getById);
    app.delete('/api/authors/:id', authorsCtl.delete);
    app.put('/api/authors/:id', authorsCtl.update);
    // app.all('*',(req,res)=> res.sendFile(__dirname + '../../public/dist/public/index.html'));
}