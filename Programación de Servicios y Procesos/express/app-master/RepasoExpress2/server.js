var express = require('express'),
app = express(),
mongoose = require('mongoose'),
User = require('./modelo/personasModelo'),
port = process.env.PORT || 3000;

mongoose.connect('mongodb://localhost/ejercicio');

var route = require('./rutas/personasRutas');
route(app);

app.listen(port);
console.log("Corriendo en el puerto: " + port);
