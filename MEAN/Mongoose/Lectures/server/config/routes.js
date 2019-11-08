const dojoCtl = require('../controllers/dojos')

module.exports = app => {
    app.get('/', dojoCtl.index);
    
    app.post('/dojos', dojoCtl.create);
    
    app.get('/dojos/:id/delete', dojoCtl.delete);
}