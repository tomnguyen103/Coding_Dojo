const petsCtr = require('../controllers/pets')

module.exports = app => {
    app.get('/api/pets', petsCtr.index);
    app.post('/api/pets', petsCtr.create);
    app.get('/api/pets/:id', petsCtr.getById);
    app.delete('/api/pets/:id', petsCtr.delete);
    app.put('/api/pets/:id',petsCtr.update);
}