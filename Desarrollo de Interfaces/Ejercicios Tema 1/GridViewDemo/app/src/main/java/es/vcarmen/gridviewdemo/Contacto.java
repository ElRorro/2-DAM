package es.vcarmen.gridviewdemo;

/**
 * Created by matinal on 30/10/2017.
 */

public class Contacto {
    private String nombre;
    private String apellidos;
    private int foto;

    public Contacto() {
    }

    public Contacto(String nombre, String apellidos, int foto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
