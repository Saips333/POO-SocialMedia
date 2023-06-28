package main.models;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime data;
    private String mensagem;

    public Comentario(LocalDateTime data, String mensagem) {
        this.data = data;
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "data=" + data +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}

