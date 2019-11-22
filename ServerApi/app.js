const express = require('express');
const app = express();
const nodoRoutes = require('./api/routes/Nodos');
const aristaRoutes = require('./api/routes/Aristas');
const grafoRoutes = require('./api/routes/Grafo');

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.use('/Nodos', nodoRoutes);
app.use('/Aristas', aristaRoutes);
app.use('/Grafo', grafoRoutes);

app.use((req,res,next)=> {
    const error = new Error('El endpoint indicado no existe');
    error.status = 404;
    next(error);
})

app.use((error,req,res,next)=> {
    res.status(error.status || 500);
    res.json({
        error:{
            message: error.message
        }
    })
})

module.exports = app;