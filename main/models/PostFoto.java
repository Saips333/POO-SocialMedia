package main.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostFoto implements Postavel {
    private int qtdeFotos;
    private List<Foto> fotos;
    private String localizacao;
    private LocalDateTime dataPostagem;
    private List<Comentario> listaComentarios;
    private int qtdeFixados;

    public PostFoto() {
        this.qtdeFotos = 0;
        this.fotos = new ArrayList<>();
        this.localizacao = null;
        this.dataPostagem = null;
        this.listaComentarios = new ArrayList<>();
        this.qtdeFixados = 0;
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

    public void fixaComentario(Comentario comentario) {
        if (!comentario.isFixado()) {
            comentario.setFixado(true);
            qtdeFixados++;
            rearrangeComentarios();
        }
    }

    public void desfixaComentario(Comentario comentario) {
        if (comentario.isFixado()) {
            comentario.setFixado(false);
            qtdeFixados--;
            rearrangeComentarios();
        }
    }
    
    private void rearrangeComentarios() {
        listaComentarios.sort(Comparator.comparing(Comentario::isFixado).reversed());
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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
        rearrangeComentarios();
    }

    public int getQtdeFotos() {
        return qtdeFotos;
    }

    public void setQtdeFotos(int qtdeFotos) {
        this.qtdeFotos = qtdeFotos;
    }

    public int getQtdeFixados() {
        return qtdeFixados;
    }

    public void setQtdeFixados(int qtdeFixados) {
        this.qtdeFixados = qtdeFixados;
    }

    @Override
    public String toString() {
        return "PostFoto{" +
                "qtdeFotos=" + qtdeFotos +
                ", fotos=" + fotos +
                ", localizacao='" + localizacao + '\'' +
                ", dataPostagem=" + dataPostagem +
                ", listaComentarios=" + listaComentarios +
                ", qtdeFixados=" + qtdeFixados +
                '}';
    }
}













