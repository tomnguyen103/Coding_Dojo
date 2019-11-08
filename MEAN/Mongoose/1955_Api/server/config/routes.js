const nameController = require('../controllers/names');

module.exports = app=>{
    app.get('/',nameController.index);
    app.get('/new/:name/',nameController.newName);
    app.get('/remove/:name/',nameController.removeName);
    app.get('/:name',nameController.singleName);
}