var fs = require('fs');
var arrayPersonas = require('./arrayPersonas')

module.exports = function lectura(callback) {
  var arrayPersonas = [];
  fs.readFile('datos.csv', 'utf-8', function(err, datos){
    if(err) throw err;
    var lineas = datos.split('\n');
    for (var i = 1; i < lineas.length-1; i++){
      //pasamos cada linea a un array por lo tanto cada linea sera un array en trozo, y cada campo
      //está separado por .split que el parametro es la coma(',')
      var trozo = lineas[i].split(',');
      //creamos un objeto persona
      var persona = {};
      //el objeto persona tiene los siguientes campos que equivalen a las posiciones del array trozo
      persona.nombre = trozo[0];
      persona.apellido = trozo[1];
      persona.email = trozo[2];
      persona.sexo = trozo[3];
      persona.edad = parseInt(trozo[4]);

      //almacenamos en cada array la persona creada
      arrayPersonas.push(persona);
      //console.log();
    }
    var arrayPersonas2 = coleccionPersonas(arrayPersonas);
    var coleccionPersonasMismoSexo = arrayPersonas2.personasIgualSexo('M');

    var coleccionPersonasMasEdad = arrayPersonas2.personasConMasEdad(23);

    var personasExtremos = arrayPersonas2.personasMasEdadMenos();

    return callback(arrayPersonas, coleccionPersonasMismoSexo, coleccionPersonasMasEdad, personasExtremos);
  });
}

/*console.log('Fin del programa');
lectura(function (datos) {
  console.log(datos);
});*/
