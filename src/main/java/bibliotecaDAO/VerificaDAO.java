/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaDAO;

import coneccaobanco.ConnectionArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Livro;
import modelos.Usuario;

/**
 *
 * @author gusta
 */
public class VerificaDAO {
    
    public static boolean verificaCadastro(Usuario usuario){
        
        boolean verificador = false;
        Connection conexao = null;
        PreparedStatement pstm  = null;
        String sql = "select * from usuarios";

        ResultSet resultado = null; 

        try {
            conexao = ConnectionArea.connectToMySQL();
            pstm = (PreparedStatement) conexao.prepareStatement(sql);

            resultado = pstm.executeQuery();

            while(resultado.next()){
                if(usuario.getEmail().equals(resultado.getString("email"))){
                    verificador = true;
                }
            }
            
            System.out.println("Verificado com sucesso");
            System.out.println(verificador);
        }catch(Exception e) {
            e.printStackTrace();
        }finally{

            try{
                if(resultado != null){
                    resultado.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return verificador;
    }

    public static boolean verificaLogin(Usuario usuario){

        boolean verificador = false;
        Connection conexao = null;
        PreparedStatement pstm  = null;
        String sql = "select * from usuarios";

        ResultSet resultado = null; 

        try {
            conexao = ConnectionArea.connectToMySQL();
            pstm = (PreparedStatement) conexao.prepareStatement(sql);

            resultado = pstm.executeQuery();

            while(resultado.next()){
                if(usuario.getEmail().equals(resultado.getString("email")) && usuario.getSenha().equals(resultado.getString("senha"))){
                    verificador = true;
                }
            }
            
            System.out.println("Usuario verificado com sucesso");
        }catch(Exception e) {
            e.printStackTrace();
        }finally{

            try{
                if(resultado != null){
                    resultado.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return verificador;
    }

    public static boolean verificaLivro(Usuario usuario){

        boolean verificador = false;
        Connection conexao = null;
        PreparedStatement pstm = null;
        String sql = "select * from livros ";
        ResultSet resultado = null;

        try{
            conexao = ConnectionArea.connectToMySQL();
            pstm = (PreparedStatement) conexao.prepareStatement(sql);

            Livro livro = (Livro) usuario.getLivrosUsuario().get(0);
                
            resultado =  pstm.executeQuery();

            while(resultado.next()){
                if(livro.getNome().equals(resultado.getString("nome"))){
                    verificador = true;
                }
            }
            System.out.println("Livro verificado com sucesso");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(resultado != null){
                    resultado.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return verificador;
    }
}
