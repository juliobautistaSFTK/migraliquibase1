package com.example.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medidas2", schema = "mibase1") // Asegúrate de que el esquema y la tabla coincidan con tu base de datos
public class Medidas2 {

    @Id
    @Column(name = "idd")
    private int idd;

    @Column(name = "tipo", nullable = false)
    private int tipo;

    @Column(name = "cantidad")
    private Short cantidad;

    @Column(name = "tipo_cambio", length = 255)
    private String tipoCambio;

    @Column(name = "comentarios", length = 255)
    private String comentarios;

    // Getters and Setters
    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public void setcomentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Medidas2{" +
                "idd=" + idd +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                ", tipoCambio='" + tipoCambio + '\'' +
                '}';
    }
}
