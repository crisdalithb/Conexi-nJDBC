package conexionbdchatarreriacaldas;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBDChatarreriaCaldas {

    
    public static void main(String[] args) {
        String usuario = "root";
        String password = "rootM2021.";
        String url = "jdbc:mysql://localhost:3306/chatarreria_caldas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            
            //Consulta a la base de datos
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT nombre, correo FROM usuario");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                
                System.out.println("Nombre: " + nombre + ",Correo: " + correo);
            }
            
            //Insertar a la base de datos
            statement.execute("INSERT INTO `usuario`(`nombre`, `contrasena`, `correo`) VALUES ('rosa','123455675','rosa@hotmail.com')");
            System.out.println("");
            rs = statement.executeQuery("SELECT nombre, correo FROM usuario");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                
                System.out.println("Nombre: " + nombre + ",Correo: " + correo);
            }
            
            //Actualizar en la base de datos
              statement.execute("UPDATE `usuario` SET `correo`='migdali2@gmail.com' WHERE `usuario`.`idusuario`= 1");
            System.out.println("");
            rs = statement.executeQuery("SELECT nombre, correo FROM usuario");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                
                System.out.println("Nombre: " + nombre + ",Correo: " + correo);
            }
            //Eliminar en la base de datos
              statement.execute("DELETE FROM `usuario` WHERE `idusuario` = 9");
            System.out.println("");
            rs = statement.executeQuery("SELECT nombre, correo FROM usuario");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                
                System.out.println("Nombre: " + nombre + ",Correo: " + correo);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBDChatarreriaCaldas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
