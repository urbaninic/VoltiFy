package com.example.voltify;

public class Song {

    private String title;
    private String author;
    private String genre;
    private String length;

    public Song (String title, String author, String genre, String length)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    // classe Song eredita metodo toString da classe padre (classe Oblject)
    public String toString()
    {
        return "Titolo: "+title+" "+"Autore: "+author+" "+"Genere: "+genre+" "+"Durata: "+length;
    }




}
