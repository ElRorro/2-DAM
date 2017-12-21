var mongoose = require('mongoose')
var db = mongoose.connect('mongodb://localhost/ejercicio');
var Schema = mongoose.Schema;

var personasSchema = new Schema ({


});

var Persona = mongoose.model('Persona', personasSchema);
module.exports.Persona = Persona;
