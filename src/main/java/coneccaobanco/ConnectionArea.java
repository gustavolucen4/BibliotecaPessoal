/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coneccaobanco;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gusta
 */
public class ConnectionArea {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/bibliotecapessoal";

    public static Connection connectToMySQL() throws Exception{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);
        return connection;
    }
    
    public static void main(String[] args) throws Exception {

            Connection conn = connectToMySQL();

            if(conn != null) {
                    System.out.println("Conexão estabelecida com sucesso");
                    conn.close();
            }
    }
}
