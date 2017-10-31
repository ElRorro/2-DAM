var circunferencia  = require ('./circuferencia');
var estadistica     = require ('./estadistica');
var cadena = require ('./cadena')

//Declaramos un objeto circunferencia
var objeto1         = circunferencia(12);
console.log("Area " + objeto1.area());
console.log("Perimetro " + objeto1.perimetro());
console.log("---------------------------");

//Declaramos un array y un objeto para pasar el array al Modulo estadística
var coleccion = [10,3,3,1,2,6,7,3,8];
var objeto2   = estadistica(coleccion);
//argumento que pasar a function numeroRepetidoColeccion()
var argumentoNumero = 3;
console.log('Nº de Elementos ' + objeto2.numeroElementos());
console.log('Nº más Alto es: ' + objeto2.numeroMasAlto());
console.log("Nº más Bajo es: " + objeto2.numeroMasBajo());
console.log("El número " + argumentoNumero + " se repite en la colección " + objeto2.numeroRepetidoColeccion(argumentoNumero) + " veces.");
console.log("La coleccion " + coleccion + " ordenada queda así: " + objeto2.ordernarColeccion());
console.log("El valor promedio de la coleccion es: " + objeto2.valorPromedioColeccion());
console.log('----------------------------------------------------------------------');

var str = 'hola'
var string = cadena(str);
console.log("Longitud de la cadena " + str + " es: " + string.longitudCadena());
console.log("La cadena " + str + " ¿Es un número?:  " + string.cadenaEsNumero());
console.log("La cadena " + str + " en mayúscula: " + string.cadenaEnMayuscula());
console.log("La cadena " + str + " al reves " + string.cadenaAlReves());
console.log("La cadena " + str + "¿es Palindromo? " + string.esPalindromo());
