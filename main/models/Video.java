package main.models;

public class Video {
    private String nome;
    private int duracao;
    private int tamanho;

    public Video(String nome, int duracao, int tamanho) {
        this.nome = nome;
        this.duracao = duracao;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Video{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", tamanho=" + tamanho +
                '}';
    }
}

