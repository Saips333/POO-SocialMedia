package main;

import java.util.List;

import main.models.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Tentativa de postagem do tipo texto
            Postavel postTexto = PostavelFactory.getPostavel("POSTEXTO");
            postTexto.posta(); // Deve retornar um erro, pois não se trata de um formato de post aceito
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de postagem com um vídeo atribuído
            Video video = new Video("video.mp4", 30, 120);
            Postavel postVideo = PostavelFactory.getPostavel("POSTVIDEO");
            ((PostVideo) postVideo).adicionaVideo(video);
            postVideo.posta(); // Deve ser publicado com sucesso
            System.out.println("Postagem com vídeo publicada com sucesso!"+ "\n");
            System.out.println(postVideo.toString()+ "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de postagem sem vídeo
            Postavel postSemVideo = PostavelFactory.getPostavel("POSTVIDEO");
            postSemVideo.posta(); // Deve retornar um erro, pois não tem vídeo atribuído
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de postagem sem foto
            Postavel postSemFoto = PostavelFactory.getPostavel("POSTFOTO");
            postSemFoto.posta(); // Deve retornar um erro, pois não tem fotos atribuídas
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de postagem com 5 fotos atribuídas
            Postavel postCincoFotos = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto1.jpg", "800x600"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto2.jpg", "800x600"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto3.jpg", "800x600"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto4.jpg", "800x600"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto5.jpg", "800x600"));
            postCincoFotos.posta(); // Deve ser publicado com sucesso
            System.out.println("Postagem com 5 fotos publicada com sucesso!" + "\n");
            System.out.println(postCincoFotos.toString()+ "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }

        try {
            // Tentativa de postagem com 11 fotos atribuídas
            Postavel postOnzeFotos = PostavelFactory.getPostavel("POSTFOTO");
            for (int i = 0; i < 11; i++) {
                ((PostFoto) postOnzeFotos).adicionaFoto(new Foto("foto.jpg", "800x600"));
            }
            postOnzeFotos.posta(); // Deve retornar um erro, pois excede o limite de 10 fotos
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }

        try {
            // Tentativa de criação de comentário em uma postagem com foto
            Postavel postComentarioFoto = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postComentarioFoto).adicionaFoto(new Foto("foto.jpg", "800x600"));
            postComentarioFoto.posta();
            postComentarioFoto.comenta("teste1"); // Deve criar um comentário com sucesso
            System.out.println("Comentário adicionado com sucesso na postagem com foto!"+ "\n");
            System.out.println(postComentarioFoto.toString()+ "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de criação de comentário em uma postagem com vídeo
            Postavel postComentarioVideo = PostavelFactory.getPostavel("POSTVIDEO");
            ((PostVideo) postComentarioVideo).adicionaVideo(new Video("video.mp4", 30, 120));
            postComentarioVideo.posta();
            postComentarioVideo.comenta("teste2"); // Deve criar um comentário com sucesso
            System.out.println("Comentário adicionado com sucesso na postagem com vídeo!"+ "\n");
            System.out.println(postComentarioVideo.toString()+ "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de criação de vídeo inválido
            Video videoInvalido = new Video("video.avi", 30, 120);
            Postavel postVideoInvalido = PostavelFactory.getPostavel("POSTVIDEO");
            ((PostVideo) postVideoInvalido).adicionaVideo(videoInvalido);
            postVideoInvalido.posta(); // Deve retornar um erro, pois a extensão do vídeo é inválida
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de criação de foto inválida
            Foto fotoInvalida = new Foto("foto.tiff", "800x600");
            Postavel postFotoInvalida = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postFotoInvalida).adicionaFoto(fotoInvalida);
            postFotoInvalida.posta(); // Deve retornar um erro, pois a extensão da foto é inválida
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }

        try {
            // Tentativa de fixar comentários 
            Postavel postFixaComentariosFoto = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postFixaComentariosFoto).adicionaFoto(new Foto("foto.jpg", "800x600"));
            postFixaComentariosFoto.posta();
            postFixaComentariosFoto.comenta("Comentário 1");
            postFixaComentariosFoto.comenta("Comentário 2");
            postFixaComentariosFoto.comenta("Comentário 3");
            postFixaComentariosFoto.comenta("Comentário 4");
            postFixaComentariosFoto.comenta("Comentário 5");

            // Fixar os dois ultimos comentários
             List<Comentario> comentarios = ((PostFoto) postFixaComentariosFoto).getListaComentarios();
             int size = comentarios.size();
             Comentario comentario1 = comentarios.get(size-2);
             Comentario comentario2 = comentarios.get(size-1);
             ((PostFoto) postFixaComentariosFoto).fixaComentario(comentario1);
             ((PostFoto) postFixaComentariosFoto).fixaComentario(comentario2);

            System.out.println("Comentários fixados com sucesso!"+ "\n");
            System.out.println(postFixaComentariosFoto.toString()+ "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }
        try {
            // Tentativa de fixar comentários em um PostVideo
             Postavel postFixaComentariosVideo = PostavelFactory.getPostavel("POSTVIDEO");
            ((PostVideo) postFixaComentariosVideo).adicionaVideo(new Video("video.mp4", 30, 120));
            postFixaComentariosVideo.posta();
            postFixaComentariosVideo.comenta("Comentário 1");
            postFixaComentariosVideo.comenta("Comentário 2");
            postFixaComentariosVideo.comenta("Comentário 3");
            postFixaComentariosVideo.comenta("Comentário 4");
            postFixaComentariosVideo.comenta("Comentário 5");

            // Fixar os dois últimos comentários
            List<Comentario> comentarios = ((PostVideo) postFixaComentariosVideo).getListaComentarios();
            int size = comentarios.size();
            Comentario comentario1 = comentarios.get(size - 2);
            Comentario comentario2 = comentarios.get(size - 1);
            ((PostVideo) postFixaComentariosVideo).fixaComentario(comentario1);
            ((PostVideo) postFixaComentariosVideo).fixaComentario(comentario2);

            System.out.println("Comentários fixados com sucesso!\n");
            System.out.println(postFixaComentariosVideo.toString() + "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }

    }
}












