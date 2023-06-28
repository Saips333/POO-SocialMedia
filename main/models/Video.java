package main.models;

public class Video extends Recurso {
    private int frameRate;
    private int duracao;

    public Video(String urlRecurso, int frameRate, int duracao) {
        super(urlRecurso);
        this.frameRate = frameRate;
        this.duracao = duracao;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public boolean validaUrlRecurso() {
        String extensao = getUrlRecurso().substring(getUrlRecurso().lastIndexOf('.'));
        return extensao.equalsIgnoreCase(".mp4") || extensao.equalsIgnoreCase(".mov") || extensao.equalsIgnoreCase(".wmv");
    }

   
}
