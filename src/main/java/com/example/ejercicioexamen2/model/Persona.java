package com.example.ejercicioexamen2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement(name="persona")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona implements Serializable, Comparable<Persona> {

    @XmlAttribute(name="dni")
    private String DNI;
    private String nombre;
    private String apellidos;
    private String dirrecion;
    private String fechaNac;

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dirrecion='" + dirrecion + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", numPrestamos=" + numPrestamos +
                '}';
    }

    public byte getNumPrestamos() {
        return numPrestamos;
    }

    public void setNumPrestamos(byte numPrestamos) {
        this.numPrestamos = numPrestamos;
    }

    private byte numPrestamos;

    public Persona(String DNI, String nombre, String apellidos, String dirrecion, String fechaNac) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dirrecion = dirrecion;
        this.fechaNac = fechaNac;
        this.numPrestamos = 1;
    }

    public Persona() {}

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public int compareTo(Persona o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
