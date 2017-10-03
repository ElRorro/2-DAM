/*for (var i = 0; i < process.argv.length; i++){
	console.log('Argumento ' + i + ":" + process.argv[i]);
};*/

if (procces.argv.length < 3) {
	procces.exit(1);
}

console.log('Cadena leida: ' + process.argv[2]);
var cadena = procces.argv[2];

function pocesarCadena(valorCadena){
	var _cadena = valorCadena;
	//todo lo que se define aqui, es privado.
	return {
		longitudCadena: function(){return _cadena.length; },
		cadenaEsNumero: function(){return !(isNaN(_cadena)); },
		cadenaEnMayuscula: function() { return _cadena.toUpperCase(); }
	};
}

var cadena1 = procesarCadena(cadena);
console.log("Longitud de la cadena " + cadena + " es": " + cadena1.procesarCadena());
console.log("La cadena " + cadena + " ¿Es un número? ": " + cadena1.cadenaEsNumero());
console.log("La cadena " + cadena + " en mayúscula ": " + cadena1.cadenaEnMayuscula());

