package GestonMagias

class Personajes (
    private var nombrePersonaje: String,
    private var localidad: String,
    private var tipoMagia: String
){

    /*Getters y Setters*/

    fun getNombrePersonajes(): String{
        return this.nombrePersonaje
    }

    fun setNombrePersonaje(nombrePersonaje: String){
        this.nombrePersonaje = nombrePersonaje
    }

    fun getLocalidad(): String{
        return this.localidad
    }

    fun setLocalidad(localidad: String){
        this.localidad = localidad
    }

    fun getTipoMagia(): String{
        return this.tipoMagia
    }

    fun setTipoMagia(tipoMagia: String){
        this.tipoMagia = tipoMagia
    }

    //Metodo to String sobreescrito
    override fun toString(): String {
        return "[nombrePersonaje = ${this.nombrePersonaje}, localidad = $localidad, tipo = $tipoMagia]"
    }
}