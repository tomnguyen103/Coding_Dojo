const authorsCtl = require('../controllers/authors')

module.exports = app => {
    app.get('/api/authors', authorsCtl.index);
    app.post('/api/authors', authorsCtl.create);
    app.get('/api/authors/:id', authorsCtl.getById);
    app.delete('/api/authors/:id', authorsCtl.delete);
    app.put('/api/authors/:id', authorsCtl.update);
    // app.all('*',(req,res)=> res.sendFile(__dirname + '../../public/dist/public/index.html'));
}