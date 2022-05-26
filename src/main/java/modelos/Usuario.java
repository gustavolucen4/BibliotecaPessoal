/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Usuario {
        
    private static String email;
    private static String senha;
    private static String nome;
    private final List<Livro> livros;

    public Usuario() {
        this.livros = new ArrayList<>();
    }

    public void setEmail(String email){
        Usuario.email = email;
    }
    public String getEmail() {
        return Usuario.email;
    }
    public void setSenha(String senha) {
        Usuario.senha = senha;
    }
    public String getSenha() {
        return Usuario.senha;
    }
    public void setNome(String nome){
        Usuario.nome = nome;
    }
    public String getNome() {
        return Usuario.nome;
    }
    public List getLivrosUsuario(){
        return this.livros;
    }
    public void addLivro(Livro livro){
        this.livros.add(livro);
    }
    public void removeLivro(){
        this.livros.remove(0);
    }
}
