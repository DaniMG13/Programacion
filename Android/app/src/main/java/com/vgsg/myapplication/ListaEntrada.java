package com.vgsg.myapplication;

public class ListaEntrada {
    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private double precio;

    public ListaEntrada (int idImagen, String textoEncima, String textoDebajo,double precio) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.precio = precio;
    }

    public String get_textoEncima() {
        return textoEncima;
    }

    public String get_textoDebajo() {
        return textoDebajo;
    }

    public int get_idImagen() {
        return idImagen;
    }
}
