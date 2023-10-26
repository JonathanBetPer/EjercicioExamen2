package com.example.ejercicioexamen2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="libro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Libro implements Serializable {
    @XmlAttribute(name="isbn")
    private String ISBN;
    private String titulo;
    private String editorial;
    private String autor;
    private int stock;

    public Libro(String ISBN, String titulo, String editorial, String autor, int stock) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.stock = stock;
    }

    public Libro() {}

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", autor='" + autor + '\'' +
                ", stock=" + stock +
                '}';
    }
}
