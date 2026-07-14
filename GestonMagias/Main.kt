package GestonMagias

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

    val baseDatos = Conection(servidor, usuario, contrasenya, base)

    baseDatos.getConnection(servidor, usuario, contrasenya)

    //Falta el driver jdbc tanto para kotlin como para java
}