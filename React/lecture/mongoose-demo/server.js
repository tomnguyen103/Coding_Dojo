const express = require('express');
const mongoose = require('mongoose');

const port = 3444;

mongoose.connect('mongodb://localhost/mongoose_demo', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});


const CitySchema = new mongoose.Schema({
    name: {
        type: String,
        required: [
            true,
            "Please provide a name"
        ]
    },
    population: {
        type: Number,
        required: [
            true,
            "Please provide a population"
        ]
    },
    imageUrl: {
        type: String,
        required: [
            true,
            "Please provide an image"
        ]
    },
}, { timestamps: true });

const City = mongoose.model('City', CitySchema);


const app = express();

app.use(express.json());

app.post('/api/cities', (req, res) => {
    City.create(req.body)
        .then(cities => res.json(cities))
        .catch(err => res.json(err))
});

app.get('/api/cities', (_req, res) => {
    City.find()
        .then(cities => res.json(cities))
        .catch(err => res.json(err))
})

app.get('/api/cities/:id', (req, res) => {
    City.findById(req.params.id)
        .then(city => res.json(city))
        .catch(err => res.json(err))
})

app.delete('/api/cities/:id', (req, res) => {
    City.findByIdAndDelete(req.params.id)
        .then(() => res.json({ status: 'success' }))
        .catch(err => res.json(err))
})


app.put('/api/cities/:id', (req, res) => {
    City.findByIdAndUpdate(
            req.params.id, {
                name: req.body.name,
                population: req.body.population,
                imageUrl: req.imageUrl
            }, {
                runValidators: true,
                new: true
            }
        )
        .then((city) => res.json(city))
        .catch(err => res.json(err))
})

app.listen(port, () => console.log('Listening on port ' + port));