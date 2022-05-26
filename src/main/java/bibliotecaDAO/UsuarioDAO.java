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
import java.util.concurrent.ExecutionException;
import modelos.Usuario;
import visao.TelaHome;
import visao.TelaPerfil;

/**
 *
 * @author gusta
 */
public class UsuarioDAO {

    public static Usuario usuarioLogado;
    
    public static boolean save(Usuario usuario) throws Exception{
        
        usuarioLogado = new Usuario();
        boolean verificador = false;
        Connection conexao = null;
        PreparedStatement pstm  = null;
        String sql = "insert into usuarios(nome, email, senha) values(?, ?, ?)";

        if(!(VerificaDAO.verificaCadastro(usuario))){

            try {
                conexao = ConnectionArea.connectToMySQL();
                pstm = (PreparedStatement) conexao.prepareStatement(sql);

                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getSenha());

                pstm.execute();
                verificador = true;
                TelaHome.atalizaPaginaHome();
                TelaPerfil.atalizaPaginaPerfil();
                System.out.println("Contato Salvo");

            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("Problema ao se conectar com o banco de dados");
                verificador = false;
            }finally{

                try{
                    if(pstm != null){
                        pstm.close();
                    }
                    if(conexao != null){
                        conexao.close();
                    }
                }catch(Exception e){
                    System.out.println("Problema ao encerrar conexão com o banco de dados");
                }
            }
        }else{
            System.out.println("Usuário já existe");
        }
        
        return verificador;
    }

    public static boolean login(Usuario usuario) throws Exception {
       
        usuarioLogado = new Usuario();
        boolean verificador = false;
        
        verificador = VerificaDAO.verificaLogin(usuario);
        
        if(verificador){
            getUsuarioLogado(usuario);
            TelaHome.atalizaPaginaHome();
            TelaPerfil.atalizaPaginaPerfil();
        }
     
        return verificador;
    }

    private static void getUsuarioLogado(Usuario usuario) throws Exception{
        
        Connection conexao = null;
        PreparedStatement pstm = null;
        String email = usuario.getEmail();
        String sql = "select * from usuarios where email = '" + email + "'";
        
        ResultSet resultado = null;

        try{
            conexao = ConnectionArea.connectToMySQL();
            pstm = (PreparedStatement) conexao.prepareStatement(sql);
            
            resultado = pstm.executeQuery();

            while(resultado.next()){
            usuarioLogado.setEmail(resultado.getString("email"));
            usuarioLogado.setNome(resultado.getString("nome"));
            usuarioLogado.setSenha(resultado.getString("senha"));
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("aqui 1");
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
    }

}
