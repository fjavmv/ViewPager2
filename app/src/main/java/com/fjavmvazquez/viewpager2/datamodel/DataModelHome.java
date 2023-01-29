package com.fjavmvazquez.viewpager2.datamodel;

public class DataModelHome {
    private String titulo;
    private int monto;

    public DataModelHome(String titulo, int monto) {
        this.titulo = titulo;
        this.monto = monto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "DataModelHOme{" +
                "titulo='" + titulo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
