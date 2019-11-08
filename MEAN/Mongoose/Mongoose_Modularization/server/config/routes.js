const animalController = require('../controllers/mongooses')

module.exports = app=>{
app.get('/',animalController.index);

app.get('/new',animalController.new);

app.post('/animal',animalController.addAnimal);

app.get('/delete/:id',animalController.delete);

app.get('/edit/:id',animalController.edit);

app.get('/animal/:id',animalController.show1);

app.post('/animal/:id',animalController.show2);
}