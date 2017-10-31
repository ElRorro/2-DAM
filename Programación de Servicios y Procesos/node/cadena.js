/*for (var i = 0; i < process.argv.length; i++){
	console.log('Argumento ' + i + ":" + process.argv[i]);
};*/

/*if (process.argv.length < 3) {
	process.exit(1);
}

console.log('Cadena leida: ' + process.argv[2]);
const cadena = process.argv[2];*/

module.exports = function cadena(valorCadena){
	var _cadena = valorCadena;
	//todo lo que se define aqui, es privado.
	return {
		longitudCadena: function(){ return _cadena.length; },
		cadenaEsNumero: function(){ return !(isNaN(_cadena)); },
		cadenaEnMayuscula: function() { return _cadena.toUpperCase(); },
		cadenaAlReves: function() { return _cadena.split('').reverse().join(''); },
		esPalindromo: function() { return _cadena === this.cadenaAlReves(); }
	};
}

/*const cadena1 = procesarCadena(cadena);
console.log("Longitud de la cadena " + cadena + " es: " + cadena1.longitudCadena());
console.log("La cadena " + cadena + " ¿Es un número?:  " + cadena1.cadenaEsNumero());
console.log("La cadena " + cadena + " en mayúscula: " + cadena1.cadenaEnMayuscula());
console.log("La cadena " + cadena + " al reves " + cadena1.cadenaAlReves());
console.log("La cadena " + cadena + "¿es Palindromo? " + cadena1.esPalindromo());*/
