package GestonMagias

import kotlin.compareTo

class Magia (
    private var nombre: String
){
    fun getNombre(): String{
        return this.nombre
    }

    fun setNombre(nombre:String){
        this.nombre = nombre
    }

    //Un metodo sobreescrito debe poner el overide delante del
    //nombre de la funcion, a diferencia de java que va arriba con un @
    //@Override
    override fun toString():String{
        return "La magia se llama $nombre"
    }

    fun anyadirLista(elemento :String) {
       //Aqui se creara una lista de elementos que se introduciran por consola.
        var magiaList = ArrayList<String>(10)

        try {
            magiaList.add(elemento)
            if (magiaList.size != 10) {
                while (magiaList.size < 10){
                    println("Introduce el nombre de la magia")
                    var nuevoElemento = readln()
                    magiaList.add(nuevoElemento)
                }
            }else{
                println("$magiaList esta completo");
            }
            println("$magiaList")
        }catch (e: ArrayIndexOutOfBoundsException){
            println("Error -> $e.message");
        }
    }

    fun validarElemento(elemento: String) :Boolean{
        if(elemento.contains("Fuego")){
            println("El elemento principal de la llama pura")
            return true
        }else if(elemento.contains("Agua")){
            println("El elemento principal de la vida y la sanacion")
            return true
        }else{
            println("Pertenece a otro tipo de elemento")
            return false
        }
    }

}
