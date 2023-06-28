package main.models;

public class PostavelFactory {
    public static Postavel getPostavel(String tipoPostavel) {
        if (tipoPostavel.equalsIgnoreCase("POSTVIDEO")) {
            return new PostVideo();
        } else if (tipoPostavel.equalsIgnoreCase("POSTFOTO")) {
            return new PostFoto();
        } else {
            throw new IllegalArgumentException("Tipo de postagem inválido.");
        }
    }
}
