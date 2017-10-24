var fs = requite('fs');
var data = fs.readFile('etc/passwd', 'utf-8', fuction(err, datos){
if (err) console.log("Error en la lectura " + err);
console.log(datos);
});
console.log("Fin de programa");
