import { Persona } from "./Persona";

let arrayPersonas = new Array<Persona>();
arrayPersonas.push(new Persona('Pepe', 'García Maroto', 200));
arrayPersonas.push(new Persona('Carlos', 'García Montero', 300));
arrayPersonas.push(new Persona('Jesús', 'Gámez Martinez', 100));
arrayPersonas.push(new Persona('Ana', 'García Maroto', 200));
arrayPersonas.push(new Persona('Esperanza', 'García Montero', 300));
arrayPersonas.push(new Persona('Alejandro', 'Gámez Martinez', 100));

let sumaTotalSalario = 0;
sumaTotalSalario = Persona.devolverSalario(arrayPersonas);

for (let persona of arrayPersonas) {
    console.log(persona.toString());
    
}

console.log("El pago total de todos los salarios es: " + sumaTotalSalario);