/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matinal
 */
public class Procesos2 {
    
    public static void main(String[] args) {
       List<String> commands = new ArrayList<>();
       commands.add("ls");
       commands.add("-la");
       ProcessBuilder pBuilder = new ProcessBuilder(commands);
       pBuilder.directory(new File("/home/psp"));
       
       try {
           Process process = pBuilder.start();
           BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
           String linea;
           while((linea = bReader.readLine()) != null){
               System.out.println(linea); 
           }
       } catch (IOException ex) {
            Logger.getLogger(Procesos2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
