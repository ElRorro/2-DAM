"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Persona = /** @class */ (function () {
    function Persona(nombre, apellidos, salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }
    Persona.prototype.getNombre = function () {
        return this.nombre;
    };
    Object.defineProperty(Persona.prototype, "miNombre", {
        set: function (nombre) {
            this.nombre = nombre;
        },
        enumerable: true,
        configurable: true
    });
    Persona.prototype.getApellidos = function () {
        return this.apellidos;
    };
    Object.defineProperty(Persona.prototype, "miApellidos", {
        set: function (apellidos) {
            this.apellidos = apellidos;
        },
        enumerable: true,
        configurable: true
    });
    Persona.prototype.getSalario = function () {
        return this.salario;
    };
    Object.defineProperty(Persona.prototype, "mSalario", {
        set: function (salario) {
            this.salario = salario;
        },
        enumerable: true,
        configurable: true
    });
    Persona.devolverSalario = function (arrayPersonas) {
        var total = 0;
        for (var _i = 0, arrayPersonas_1 = arrayPersonas; _i < arrayPersonas_1.length; _i++) {
            var persona = arrayPersonas_1[_i];
            total = total + persona.getSalario();
        }
        return total;
    };
    Persona.prototype.toString = function () {
        return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", Salario: " + this.salario;
    };
    return Persona;
}());
exports.Persona = Persona;
