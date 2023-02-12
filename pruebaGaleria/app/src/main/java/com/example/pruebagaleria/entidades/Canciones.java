package com.example.pruebagaleria.entidades;

import java.io.Serializable;

public class Canciones implements Serializable {

    private int id;
    private String nombre;
    private String autor;
    private String imagen;
    private String video;

    private String audio;

    public Canciones(int id) {
        this.id = id;
    }

    public Canciones(int id, String nombre, String autor, String imagen, String video, String audio) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.imagen = imagen;
        this.video = video;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "Canciones{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", imagen='" + imagen + '\'' +
                ", video='" + video + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }
}
