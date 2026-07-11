import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {

    //La finalidad de este ejercicio es realizar una conexión MYSQL desde java
    //para trabajar enun pequeño mini proyecto de POO básico

    public static void main(String[] args) {
        
        String conexionDB = "jdbc:mysql://localhost:3306/usuari_registre";
        String usuarioDB = "root";
        String contrasenyaDB = "root";
        //String nombreDB = "RPG_players";

        //Se establece la conexiñon con try catch
        try {
            Connection conexion = DriverManager.getConnection(conexionDB, usuarioDB, contrasenyaDB);
            
            System.out.println("Conexión establecida");
            conexion.close();
        } catch (SQLException e) {
            //TODO: handle exception
            System.out.println("Error de conexión " + e);
            //e.printStanckTrace();
        }
    }
}