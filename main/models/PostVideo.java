package main.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostVideo implements Postavel {
    private Video video;
    private LocalDateTime dataPostagem;
    private List<Comentario> listaComentarios;
    private int qtdeFixados;

    public PostVideo() {
        this.video = null;
        this.dataPostagem = null;
        this.listaComentarios = new ArrayList<>();
        this.qtdeFixados = 0;
    }

    public void adicionaVideo(Video video) {
        this.video = video;
    }

    @Override
    public boolean posta() {
        if (video != null) {
            dataPostagem = LocalDateTime.now();
            return true;
        } else {
            throw new IllegalArgumentException("Erro ao postar o vídeo: vídeo não atribuído");
        }
    }

    @Override
    public boolean comenta(String mensagem) {
        if (mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Erro ao adicionar o comentário: mensagem vazia");
        }
        Comentario comentario = new Comentario(LocalDateTime.now(), false, mensagem);
        listaComentarios.add(comentario);
        return true;
    }

    public void fixaComentario(Comentario comentario) {
        if (!comentario.isFixado()) {
            comentario.setFixado(true);
            qtdeFixados++;
        }
    }

    public void desfixaComentario(Comentario comentario) {
        if (comentario.isFixado()) {
            comentario.setFixado(false);
            qtdeFixados--;
        }
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public List<Comentario> getListaComentarios() {
        listaComentarios.sort(Comparator.comparing(Comentario::isFixado).reversed());
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public int getQtdeFixados() {
        return qtdeFixados;
    }

    public void setQtdeFixados(int qtdeFixados) {
        this.qtdeFixados = qtdeFixados;
    }

    @Override
    public String toString() {
        return "PostVideo{" +
                "video=" + video +
                ", dataPostagem=" + dataPostagem +
                ", listaComentarios=" + listaComentarios +
                ", qtdeFixados=" + qtdeFixados +
                '}';
    }
}





