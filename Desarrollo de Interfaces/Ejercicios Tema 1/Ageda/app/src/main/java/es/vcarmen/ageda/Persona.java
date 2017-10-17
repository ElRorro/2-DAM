package es.vcarmen.ageda;

import android.os.Bundle;

/**
 * Created by matinal on 03/10/2017.
 */

public class Persona{
    private String nombrePersona;
    private String apellidosPersona;
    private int telefonoPersona;
    private String sexoPersona;

    public Persona(String nombrePersona, String apellidosPersona, int telefonoPersona, String sexoPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.telefonoPersona = telefonoPersona;
        this.sexoPersona = sexoPersona;
    }

    public Persona() {
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public int getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(int telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getSexoPersona() {
        return sexoPersona;
    }

    public void setSexoPersona(String sexoPersona) {
        this.sexoPersona = sexoPersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidosPersona='" + apellidosPersona + '\'' +
                ", telefonoPersona=" + telefonoPersona +
                ", sexoPersona='" + sexoPersona + '\'' +
                '}';
    }
}
