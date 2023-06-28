package main.models;

public class Foto extends Recurso {
    private String resolucao;

    public Foto(String urlRecurso, String resolucao) {
        super(urlRecurso);
        this.resolucao = resolucao;
    }

    public String getResolucao() {
        return resolucao;
    }

    @Override
    public boolean validaUrlRecurso() {
        String extensao = getUrlRecurso().substring(getUrlRecurso().lastIndexOf('.'));
        return extensao.equalsIgnoreCase(".jpg") || extensao.equalsIgnoreCase(".png") || extensao.equalsIgnoreCase(".bmp");
    }

   
}

