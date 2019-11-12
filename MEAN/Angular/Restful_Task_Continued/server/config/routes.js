const tasksController = require('../controllers/tasks');

module.exports = app=>{
    app.get('/api/tasks', tasksController.index);
    app.post('/api/tasks', tasksController.create);
    app.get('/api/tasks/:id',tasksController.getById);
    app.put('/api/tasks/:id',tasksController.update);
    app.delete('/api/tasks/:id',tasksController.delete);
}