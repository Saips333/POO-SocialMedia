package main.models;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime data;
    private boolean fixado;
    private int tamanho;
    private String texto;

    public Comentario(LocalDateTime data, boolean fixado, String texto) {
        this.data = data;
        this.fixado = fixado;
        this.texto = texto;
        this.tamanho = texto.length();
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isFixado() {
        return fixado;
    }

    public void setFixado(boolean fixado) {
        this.fixado = fixado;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        this.tamanho = texto.length();
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "data=" + data +
                ", fixado=" + fixado +
                ", tamanho=" + tamanho +
                ", texto='" + texto + '\'' +
                '}';
    }
}


