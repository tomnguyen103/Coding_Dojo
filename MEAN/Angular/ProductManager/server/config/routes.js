const productsCtl = require('../controllers/products');

// export module
module.exports = app => {
    app.get('/api/products', productsCtl.index);
    app.post('/api/products',productsCtl.create);
    app.get('/api/products/:id', productsCtl.getById);
    app.delete('/api/products/:id', productsCtl.delete);
    app.put('/api/products/:id', productsCtl.update);
}