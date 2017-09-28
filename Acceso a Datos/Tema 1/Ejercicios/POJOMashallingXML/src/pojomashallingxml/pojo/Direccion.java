/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomashallingxml.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Direccion {
    private String tipoVida;
    private String nombreVia;
    private String numero;
    private String planta;
    private String puerta;
    private String escalera;
    private String portal;
    private String ciudad;
    private int cp;
    private String pais;
    private String provincia;

    public Direccion(String tipoVida, String nombreVia, String numero, String planta, String puerta, String escalera, String portal, String ciudad, int cp, String pais, String provincia) {
        this.tipoVida = tipoVida;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.planta = planta;
        this.puerta = puerta;
        this.escalera = escalera;
        this.portal = portal;
        this.ciudad = ciudad;
        this.cp = cp;
        this.pais = pais;
        this.provincia = provincia;
    }

    public Direccion() {
    }
    

    public String getTipoVida() {
        return tipoVida;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public String getNumero() {
        return numero;
    }

    public String getPlanta() {
        return planta;
    }

    public String getPuerta() {
        return puerta;
    }

    public String getEscalera() {
        return escalera;
    }

    public String getPortal() {
        return portal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCp() {
        return cp;
    }

    public String getPais() {
        return pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setTipoVida(String tipoVida) {
        this.tipoVida = tipoVida;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    } 
}