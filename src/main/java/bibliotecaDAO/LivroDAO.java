/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecaDAO;

import coneccaobanco.ConnectionArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Livro;
import modelos.Usuario;

/**
 *
 * @author gusta
 */
public class LivroDAO {
    
    public static boolean save(Usuario usuario){
        boolean verificador = false;

        Connection conexao = null;
        PreparedStatement pstm = null;
        String sql = "insert into livros(nome) values(?)";

        if(VerificaDAO.verificaLivro(usuario)){
            saveLivroNoUsuario(usuario);
            verificador = true;
        }else {   
            try{
                conexao = ConnectionArea.connectToMySQL();
                pstm = (PreparedStatement) conexao.prepareStatement(sql);

                Livro livro = (Livro) usuario.getLivrosUsuario().get(0);
                    
                pstm.setString(1, livro.getNome());

                verificador = true;
                pstm.execute();

            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conexao != null){
                    conexao.close();
                }   
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
            }

            saveLivroNoUsuario(usuario);
        }
        return verificador;
    }
    
    private static void  saveLivroNoUsuario(Usuario usuario){

        Connection conexao = null;
        PreparedStatement pstm = null;
        String sql = "";

        try{

            sql = "insert into biblioteca(usuario, nomelivro) values(?, ?)";
            conexao = ConnectionArea.connectToMySQL();
            pstm = (PreparedStatement) conexao.prepareStatement(sql);

            Livro livro = (Livro) usuario.getLivrosUsuario().get(0);

            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, livro.getNome());

            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conexao != null){
                    conexao.close();
                }   
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
