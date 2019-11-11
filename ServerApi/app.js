const express = require('express');
const app = express();
const nodoRoutes = require('./api/routes/Nodos');

app.use('/Nodos', nodoRoutes);
module.exports = app;