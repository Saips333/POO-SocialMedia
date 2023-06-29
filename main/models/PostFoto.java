package main.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostFoto implements Postavel {
    private int qtdeFotos;
    private List<Foto> fotos;
    private LocalDateTime dataPostagem;
    private List<Comentario> listaComentarios;

    public PostFoto() {
        this.qtdeFotos = 0;
        this.fotos = new ArrayList<>();
        this.dataPostagem = null;
        this.listaComentarios = new ArrayList<>();
    }

    public void adicionaFoto(Foto foto) {
        fotos.add(foto);
        qtdeFotos++;
    }

    public void excluiFoto(Foto foto) {
        fotos.remove(foto);
        qtdeFotos--;
    }

    @Override
    public boolean posta() {
        if (qtdeFotos >= 1 && qtdeFotos <= 10) {
            dataPostagem = LocalDateTime.now();
            return true;
        } else {
            throw new IllegalArgumentException("Erro ao postar a foto: quantidade de fotos inválida");
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

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    @Override
    public String toString() {
        return "PostFoto{" +
                "qtdeFotos=" + qtdeFotos +
                ", fotos=" + fotos +
                ", dataPostagem=" + dataPostagem +
                ", listaComentarios=" + listaComentarios +
                '}';
    }
}













