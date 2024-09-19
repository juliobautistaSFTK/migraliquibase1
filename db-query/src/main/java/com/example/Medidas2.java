package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medidas2", schema = "mibase1") // Asegúrate de que el esquema y la tabla coincidan con tu base de datos
public class medidas2 {

    @Id
    @Column(name = "idd")
    private int idd;

    @Column(name = "tipo", nullable = false)
    private int tipo;

    @Column(name = "cantidad")
    private Short cantidad;

    @Column(name = "tipo_cambio", length = 255)
    private String tipoCambio;

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
