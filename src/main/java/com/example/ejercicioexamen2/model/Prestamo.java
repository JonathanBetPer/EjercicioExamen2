package com.example.ejercicioexamen2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement(name="prestamo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prestamo implements Serializable, Comparable<Prestamo> {
    @XmlElement(name="persona")
    private Persona persona;
    @XmlElement(name="libro")
    private Libro libro;
    private String fecha;

    public Prestamo(Persona persona, Libro libro) {
        this.persona = persona;
        this.libro = libro;
        this.fecha = LocalDate.now().toString();
    }

    public Prestamo() {}

    @Override
    public String toString() {
        return "Prestamo{" +
                "persona=" + persona +
                ", libro=" + libro +
                ", fecha=" + fecha +
                '}';
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFecha() {

        return LocalDate.parse(fecha);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha.toString();
    }

    @Override
    public int compareTo(Prestamo o) {
        return this.persona.compareTo(o.persona);
    }
}
