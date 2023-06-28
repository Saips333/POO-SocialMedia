package main.models;

public abstract class Recurso {
    private int id;
    private String urlRecurso;
    private static int proximoId = 1;

    public Recurso(String urlRecurso) {
        this.id = proximoId++;
        this.urlRecurso = urlRecurso;
    }

    public int getId() {
        return id;
    }

    public String getUrlRecurso() {
        return urlRecurso;
    }

    public abstract boolean validaUrlRecurso();

   

}
