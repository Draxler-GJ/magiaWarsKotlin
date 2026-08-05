package GestonMagias

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class Conection (
    private var server: String,
    private var user: String,
    private var password: String,
    private var database: String
){
    //Getters y setters de la conexion a base de datos
    fun getServer():String{
        return this.server
    }

    fun setServer(server:String){
        this.server = server
    }


    fun getUSer():String{
        return this.user
    }

    fun setUser(user:String){
        this.user = user
    }

    fun getPassword():String{
        return this.password
    }

    fun setPassword(password:String){
        this.password = password
    }

    fun getDatabase():String{
        return this.database
    }

    fun setDatabase(database:String){
        this.database = database
    }

    //Realizar la conexion

    fun getConnection(server: String, user: String, password: String): Connection {

        Class.forName("org.mariadb.jdbc.Driver") //Donar permis a la conexio amb la base de dades

        return try {
            val connect = DriverManager.getConnection(server, user, password)
            println("Conexion realizada con exito")
            connect
        }catch (e:Exception){
            println("Error de conexion -> ${e.message}");
            throw e
        }

        //Anotaciones
        /*
        * En el try catch hay que usar return
        * En kotlin no se usa getMessage, sino message y se lanza la conexion
        */
    }
}