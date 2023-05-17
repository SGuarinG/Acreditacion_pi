package Config;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con=null;
    
    boolean Prueba(){
        boolean verificacion=false;
        JOptionPane.showMessageDialog(null,"hola");
        return verificacion;
    }
    
        public Connection getConnection() {
        return con;
    }
    
    public void conectar () throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Error al cargar el driver");
            e.printStackTrace();
            return;
        }
        
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/acreditacionpi","root","");
            System.out.println("Conexion exitosa con la base de datos");       
           
        } catch (SQLException e){
            System.out.println("Error al establecer la conexion con la base de datos");
            e.printStackTrace();
        } 
    }
    
    public void desconectar() {
        if (con != null){
            try {         
                con.close();
                System.out.println("Conexion terminada");
                } catch (SQLException e){
                System.out.println("Error al cerrar la conexion");
                e.printStackTrace();
            }
        }        
    }
}        

