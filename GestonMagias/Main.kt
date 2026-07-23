package GestonMagias

import java.sql.Connection
import java.sql.SQLSyntaxErrorException

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val nombre = "Daniel"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + nombre + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = ($i + 1)")
    }

    println("Introduce el nombre de la magia")
    var nombreElemento = readln()

    var p1 = Personajes("Rigoberto", "Sorio", nombreElemento)
    println(p1);

    var m1 = Magia(nombreElemento)

    println(m1.toString())
    println("=========================");
    println(m1.validarElemento(nombreElemento))
    println("=========================");
    //println(m1.anyadirLista(nombreElemento))

    //Conexion a la base de datos
    var servidor = "jdbc:mariadb://localhost:3306/RPG_players"
    var usuario = "root"
    var contrasenya = "root"
    var base = "RPG_players"

    val con = Conection(servidor, usuario, contrasenya, base)

    val conexion = con.getConnection(servidor, usuario, contrasenya)

    //println(conexion)

    //Falta el driver jdbc tanto para kotlin como para java
    //Driver instalado
    println("Introduzca una opcion")
    var opcion = readln().toIntOrNull()

    when(opcion){
        1 -> {
            println("Consultar")
            realizarConsulta(con.getConnection(servidor, usuario, contrasenya))
        }
        2 -> {
            println("Insertar")
            insertarPersonajes(conexion)
        }
        3 -> println("Actualizar -> Proximamente")
        4 -> println("Eliminar -> Proximamente")
        else -> println("Fin del programa")
    }
}

fun realizarConsulta(conexion: Connection){
    val st = conexion.createStatement()
    val consulta = st.executeQuery("SELECT * FROM  magia")

    while(consulta.next()){
        println("========================================================================================================")
        println("${consulta.getString("nombre_magia")} -> ${consulta.getString("descripcion")}")
    }
}

fun insertarPersonajes(conexion: Connection){
    //funcion creada para insetar personajes o magias dependiendo de la tabla
    println("Id a introducir")
    var id = readln()
    println("Introduce el nombre de una nueva magia")
    var nombreMagia = readln()
    println("Introduce una descripcion acorde a ella")
    var descripcion = readln()

    try {

        //val st = conexion.prepareStatement(st)
        val st = conexion.createStatement()
        val inserFilas = st.executeUpdate("INSERT INTO magia(id_magia,nombre_magia,descripcion) VALUES ('$id','$nombreMagia', '$descripcion')")

        if(inserFilas > 0){
            println("Insercion realizada con exito")
        }else {
            println("No se pudieron insertar los datos")
        }
    }catch(e: SQLSyntaxErrorException){
        println("Error de insecion: ${e.message}")
    }
}

fun actualizarDatos(conexion: Connection){
    //funcion creada para actualizar registros en caso de que sean necesarios
    println("Id a actualizar")
    //var id = readln()

}

fun eliminarRegistros(conexion: Connection){
        //funcion creada nica y exclusivamente para borrar datos en caso de ser necesarios
    println("Introduce Id a Eliminar")
    //var id = readln()
}
