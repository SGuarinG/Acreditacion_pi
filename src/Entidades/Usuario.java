package Entidades;

import Config.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Usuario {
    Conexion con = new Conexion();
    Statement statement = null;

    public Usuario(Conexion conexion) {
        con=conexion;
        try {
        statement = con.getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("Error al crear el statement");
            e.printStackTrace();
        }
    }

    public boolean login(String usuario, String contraseña) throws SQLException {
        boolean verificacion=false;
        if (usuario.isEmpty() || contraseña.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nos campos no pueden estar vacios");
        } else {
            String sql = "SELECT contraseña FROM usuarios WHERE nombre='" + usuario + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String tempcon = resultSet.getString("contraseña");
                if (tempcon.equals(contraseña)){
                    verificacion=true;
                    break;
                }
            }   
            if(verificacion){
                JOptionPane.showMessageDialog(null, "Inicio de seccion exitoso");
                
            }   
        }
        return verificacion;
    }
}