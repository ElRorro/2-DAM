module.exports = function (app){
  var controlador = require('../controlador/personasControlador');
  app.route('/users').get(controlador.listarPersona);
}
