package main;

import main.models.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Tentativa de postagem do tipo texto
            Postavel postTexto = PostavelFactory.getPostavel("POSTEXTO");
            postTexto.posta(); // Deve retornar um erro, pois nao se trata de um formato de post aceito
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
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto1.jpg"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto2.jpg"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto3.jpg"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto4.jpg"));
            ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto5.jpg"));
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
                ((PostFoto) postOnzeFotos).adicionaFoto(new Foto("foto.jpg"));
            }
            postOnzeFotos.posta(); // Deve retornar um erro, pois excede o limite de 10 fotos
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }

        try {
            // Tentativa de criação de comentário em uma postagem com foto
            Postavel postComentarioFoto = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postComentarioFoto).adicionaFoto(new Foto("foto.jpg"));
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
            Foto fotoInvalida = new Foto("foto.tiff");
            Postavel postFotoInvalida = PostavelFactory.getPostavel("POSTFOTO");
            ((PostFoto) postFotoInvalida).adicionaFoto(fotoInvalida);
            postFotoInvalida.posta(); // Deve retornar um erro, pois a extensão da foto é inválida
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()+ "\n");
        }
    }
}











