package main.models;

public class Video extends Recurso {
    private int frameRate;
    private int duracao;

    public Video(String urlRecurso, int frameRate, int duracao) throws IllegalArgumentException {
        super(urlRecurso);
        this.frameRate = frameRate;
        this.duracao = duracao;
        if (!validaUrlRecurso()) {
            throw new IllegalArgumentException("URL do recurso inválida: " + urlRecurso);
        }
    }

    public int getFrameRate() {
        return frameRate;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public boolean validaUrlRecurso() {
        String[] validExtensions = {".mp4", ".mov", ".wmv"};
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
        return "Video{" +
                "urlRecurso='" + getUrlRecurso() + '\'' +
                ", frameRate=" + frameRate +
                ", duracao=" + duracao +
                '}';
    }
}



