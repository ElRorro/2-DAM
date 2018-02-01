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
public class Hilos1 {
    public static void main (String[] args) {
        HiloUno hiloUno = new HiloUno();
        hiloUno.start();
        
        Thread hiloDos = new Thread(new HiloDos());
        hiloDos.start();
        
        for (int i = 0; i< 10_000; i++) {
            try {
                Thread.sleep((long) (Math.random() * 2_000));
                System.out.println("ejecución en hilo principal");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class HiloUno extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            try {
                Thread.sleep((long) (Math.random() * 2_000));
                System.out.println("ejecución en nuevo hilo");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }  
}

class HiloDos implements Runnable {
    @Override
    public void run() {
       for (int i = 0; i < 10_000; i++) {
            try {
                Thread.sleep((long) (Math.random() * 2_000));
                System.out.println("ejecución en hilo dos");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
