export class Persona {
    private nombre:string;
    private apellidos:string;
    private salario:number;

    constructor(nombre:string, apellidos:string, salario:number){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }

    getNombre(){
        return this.nombre;
    }

    set miNombre (nombre:string) {
        this.nombre = nombre;
    }

    getApellidos(){
        return this.apellidos;
    }

   set miApellidos (apellidos:string) {
        this.apellidos = apellidos;
    }

    getSalario(){
        return this.salario;
    }

    set mSalario (salario:number) {
        this.salario = salario;
    }

    static devolverSalario (arrayPersonas: Array<Persona>):number {
        let total = 0;
        for (let persona of arrayPersonas) {
            total = total + persona.getSalario();
        }
        return total;
    }

    toString() {
        return "Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ", Salario: " + this.salario;
    }
}