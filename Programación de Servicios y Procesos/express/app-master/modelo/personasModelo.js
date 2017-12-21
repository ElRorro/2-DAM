var mongoose = require('mongoose');
var db = mongoose.connect('mongodb://localhost/ejercicio');
var Schema = mongoose.Schema;

var personasSchema = new Schema({
  id: Number,
  sexo: String,
  edad: Number,
  nombre: String,
  fecha: {type: Date, default : Date.now}
});

var Humano = mongoose.model('Humanos', personasSchema);
module.exports.Humano = Humano;
