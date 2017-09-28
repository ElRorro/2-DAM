/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pojomashallingxml.pojo.Direccion;

/**
 *
 * @author matinal
 */
public class POJOMarshallingXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Direccion direccion = new Direccion("Calle", "Luna", "1", "1", "A", "Izq", "B", 
                "Jaén", 23008, "España", "Jaén");
        try {
            //Cargamos la configuración para que el "Marshaller" sepa como convertir el POJO 
            //a XML, para eso necesito la clase que previamente estaba con anotaciones JAXB
            JAXBContext jbc = JAXBContext.newInstance(direccion.getClass());
            /*
            Creamos el Marshaller que es el encargado de volcar el objeto a fichero XML, pero
            OJO este sólo sirve para la clase Direccion porque arriba hemos cargado en el contexto la clase 
            Direccion*/
            Marshaller jbcm = jbc.createMarshaller();
            /*
            Activar el HUMAN-FRIENDLY para entender el codigo*/
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Con esto generamos el fichero XML
            jbcm.marshal(direccion, new File("direcion.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    } 
}