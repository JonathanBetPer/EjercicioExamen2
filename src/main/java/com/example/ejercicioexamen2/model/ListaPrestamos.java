package com.example.ejercicioexamen2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.TreeSet;

@XmlRootElement(name = "prestamos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaPrestamos implements Serializable {

    @XmlElement(name = "prestamo")
    private TreeSet<Prestamo> lista;

    public ListaPrestamos() {
        this.lista = new TreeSet<>();
    }

    public TreeSet<Prestamo> getLista() {
        return lista;
    }

    public void setLista(TreeSet<Prestamo> lista) {
        this.lista = lista;
    }


}
