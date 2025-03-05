import java.util.UUID

class UtilidadesLibro {
    val id: String
    companion object {
        fun obtenerIdentificadorUnico(): String {
            return UUID.randomUUID().toString()
        }
    }
    init {
        id = obtenerIdentificadorUnico()
    }
}