package com.springboot.app.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String nombre;

    @Column(nullable = false,length = 20)
    private String marca;

    @Column(nullable = false,length = 60)
    private String madeIn;

    @Column(nullable = false)
    private float precio;

    public Producto (){}
    public Producto(Long id, String nombre, String marca, String madeIn, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.madeIn = madeIn;
        this.precio = precio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", madeIn='" + madeIn + '\'' +
                ", precio=" + precio +
                '}';
    }
}

