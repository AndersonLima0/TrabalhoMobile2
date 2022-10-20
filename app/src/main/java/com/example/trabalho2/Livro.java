package com.example.trabalho2;

import java.io.Serializable;

public class Livro implements Serializable {
    String autor, nomeLivro;
    int id = 0;

    public Livro(){

    }

    public Livro(String autor, String nomeLivro,int id){
        this.autor = autor;
        this.nomeLivro = nomeLivro;
        this.id = id;

    }

    public String getAutor() {
        return autor;
    }

    public String getnomeLivro() {
        return nomeLivro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setnomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String toString(){
        return "Autor: "+autor+" Livro: "+nomeLivro+"\n ID: "+id;
    }

    public int getId() {
        return id;
    }
}
