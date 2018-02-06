
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matinal
 */
public class ImprimirNumeros {
   
    public static void main (String[] args) {
        System.out.println("Introduce un numero: ");
        Scanner numero = new Scanner(System.in);
        int numeroRecoger = numero.nextInt();
        
        Thread hiloUno = new Thread(new Hilo1(numeroRecoger));
        hiloUno.start();
    }
}

class Hilo1 implements Runnable {
    int numeroRecoger;
    Hilo1(int numeroRecoger) {
        this.numeroRecoger = numeroRecoger;
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroRecoger; i++) {
            try {
                Thread.sleep((long) (Math.random() * 2_000));
                System.out.println("ejecución en hilo dos");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
