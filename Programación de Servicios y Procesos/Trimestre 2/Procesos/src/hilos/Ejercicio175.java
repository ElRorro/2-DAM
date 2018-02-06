/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matinal
 */
public class Ejercicio175 {
    public static void main (String[] args) {
        Suma hilo1 = new Suma(100_000_000);
        Suma hilo2 = new Suma(100_000_000);
        Suma hilo3 = new Suma(100_000_000);
        Suma hilo4 = new Suma(100_000_000);
        
        //Primero los iniciamos los hilos
        hilo1.start();hilo2.start();hilo3.start();hilo4.start();
        
        //En segundo lugar con la clausula try-catch ejecutamos los hilos con un join
        //Indicando con ese join que el hilo principal en este caso el main no seguirá
        //ejecutandose hasta que se hayan realizado los 4 hilos
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio175.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio175.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //Obtenemos los resultados de los hilo para finalmente hacer la suma
        long suma1 = hilo1.getResultado();
        long suma2 = hilo2.getResultado();
        long suma3 = hilo3.getResultado();
        long suma4 = hilo4.getResultado();
        long resultado = suma1 + suma2 + suma3 + suma4;
        System.out.println("Resultado: " + resultado);
    }
}

class Suma extends Thread {
    private long valor;
    private long resultado = 0;
    
    //Constructor del hilo
    public Suma(long valor) {
        super();
        this.valor = valor;
    }
    
    //Método run sobreescrito que es el método que se ejecuta al iniciar un hilo
    @Override
    public void run() {
        for (long i = 0; i < valor; i++) {
            resultado++;
        }
    }

    public long getResultado() {
        return resultado;
    }   
}
