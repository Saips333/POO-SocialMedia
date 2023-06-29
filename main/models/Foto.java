package main.models;

public class Foto extends Recurso {
    private String resolucao;

    public Foto(String urlRecurso, String resolucao) throws IllegalArgumentException {
        super(urlRecurso);
        this.resolucao = resolucao;
        if (!validaUrlRecurso()) {
            throw new IllegalArgumentException("URL do recurso inválida: " + urlRecurso);
        }
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    @Override
    public boolean validaUrlRecurso() {
        String[] validExtensions = {".jpg", ".png", ".bmp"};
        String urlRecurso = getUrlRecurso();
        for (String extension : validExtensions) {
            if (urlRecurso.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "urlRecurso='" + getUrlRecurso() + '\'' +
                ", resolucao='" + resolucao + '\'' +
                '}';
    }
}




