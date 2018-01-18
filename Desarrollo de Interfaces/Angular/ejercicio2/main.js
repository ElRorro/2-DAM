"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Persona_1 = require("./Persona");
var arrayPersonas = new Array();
arrayPersonas.push(new Persona_1.Persona('Pepe', 'García Maroto', 200));
arrayPersonas.push(new Persona_1.Persona('Carlos', 'García Montero', 300));
arrayPersonas.push(new Persona_1.Persona('Jesús', 'Gámez Martinez', 100));
arrayPersonas.push(new Persona_1.Persona('Ana', 'García Maroto', 200));
arrayPersonas.push(new Persona_1.Persona('Esperanza', 'García Montero', 300));
arrayPersonas.push(new Persona_1.Persona('Alejandro', 'Gámez Martinez', 100));
var sumaTotalSalario = 0;
sumaTotalSalario = Persona_1.Persona.devolverSalario(arrayPersonas);
for (var _i = 0, arrayPersonas_1 = arrayPersonas; _i < arrayPersonas_1.length; _i++) {
    var persona = arrayPersonas_1[_i];
    console.log(persona.toString());
}
console.log("El pago total de todos los salarios es: " + sumaTotalSalario);
