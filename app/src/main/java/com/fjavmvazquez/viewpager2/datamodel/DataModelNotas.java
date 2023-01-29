package com.fjavmvazquez.viewpager2.datamodel;

public class DataModelNotas {
    private int idFoto;
    private String titulo;
    private String descripcion;
    private String fecha;

    public DataModelNotas(int idFoto, String titulo, String descripcion, String fecha) {
        this.idFoto = idFoto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }


    public DataModelNotas(String titulo,String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }
}
