package main.models;

public class Foto {
    private String nome;

    public Foto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}


