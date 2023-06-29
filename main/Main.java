package main;

import main.models.*;

public class Main {
    public static void main(String[] args) {
        // Tentativa de postagem com texto
        Postavel postTexto = PostavelFactory.getPostavel("POSTVIDEO");
        try {
            postTexto.posta(); // Deve retornar um erro, pois não tem vídeo atribuído
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de postagem com um vídeo atribuído
        Video video = new Video("video.mp4", 30, 120);
        Postavel postVideo = PostavelFactory.getPostavel("POSTVIDEO");
        ((PostVideo) postVideo).adicionaVideo(video);
        try {
            postVideo.posta(); // Deve ser publicado com sucesso
            System.out.println("Postagem com vídeo publicada com sucesso!");
            System.out.println(postVideo.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de postagem sem vídeo
        Postavel postSemVideo = PostavelFactory.getPostavel("POSTVIDEO");
        try {
            postSemVideo.posta(); // Deve retornar um erro, pois não tem vídeo atribuído
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de postagem sem foto
        Postavel postSemFoto = PostavelFactory.getPostavel("POSTFOTO");
        try {
            postSemFoto.posta(); // Deve retornar um erro, pois não tem fotos atribuídas
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de postagem com 5 fotos atribuídas
        Postavel postCincoFotos = PostavelFactory.getPostavel("POSTFOTO");
        ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto1.jpg"));
        ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto2.jpg"));
        ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto3.jpg"));
        ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto4.jpg"));
        ((PostFoto) postCincoFotos).adicionaFoto(new Foto("foto5.jpg"));
        try {
            postCincoFotos.posta(); // Deve ser publicado com sucesso
            System.out.println("Postagem com 5 fotos publicada com sucesso!");
            System.out.println(postCincoFotos.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de postagem com 11 fotos atribuídas
        Postavel postOnzeFotos = PostavelFactory.getPostavel("POSTFOTO");
        for (int i = 0; i < 11; i++) {
            ((PostFoto) postOnzeFotos).adicionaFoto(new Foto("foto.jpg"));
        }
        try {
            postOnzeFotos.posta(); // Deve retornar um erro, pois excede o limite de 10 fotos
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de criação de comentário em uma postagem com foto
        Postavel postComentarioFoto = PostavelFactory.getPostavel("POSTFOTO");
        ((PostFoto) postComentarioFoto).adicionaFoto(new Foto("foto.jpg"));
        try {
            postComentarioFoto.posta();
            postComentarioFoto.comenta(); // Deve criar um comentário com sucesso
            System.out.println("Comentário adicionado com sucesso na postagem com foto!");
            System.out.println(postComentarioFoto.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de criação de comentário em uma postagem com vídeo
        Postavel postComentarioVideo = PostavelFactory.getPostavel("POSTVIDEO");
        ((PostVideo) postComentarioVideo).adicionaVideo(new Video("video.mp4", 30, 120));
        try {
            postComentarioVideo.posta();
            postComentarioVideo.comenta(); // Deve criar um comentário com sucesso
            System.out.println("Comentário adicionado com sucesso na postagem com vídeo!");
            System.out.println(postComentarioVideo.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de criação de vídeo inválido
        Video videoInvalido = new Video("video.avi", 30, 120);
        Postavel postVideoInvalido = PostavelFactory.getPostavel("POSTVIDEO");
        ((PostVideo) postVideoInvalido).adicionaVideo(videoInvalido);
        try {
            postVideoInvalido.posta(); // Deve retornar um erro, pois a extensão do vídeo é inválida
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentativa de criação de foto inválida
        Foto fotoInvalida = new Foto("foto.tiff");
        Postavel postFotoInvalida = PostavelFactory.getPostavel("POSTFOTO");
        ((PostFoto) postFotoInvalida).adicionaFoto(fotoInvalida);
        try {
            postFotoInvalida.posta(); // Deve retornar um erro, pois a extensão da foto é inválida
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}











