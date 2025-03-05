class InterfazDeUsuario {
    fun mostrarMenu(): Int {
        print("1) agregar elemento\n2) eliminar elemento\n3) realizar prestamo\n4) realizar devolucion\n5) consultar disponibilidad\n6) mostrar todos los elementos\nelige una opcion: ")
        val opcion = pedirDato("").toInt()
        return opcion
    }

    fun accionAgregarElemento(): Libro {
        val id = pedirDato("id del elemento: ")
        val titulo = pedirDato("titulo del elemento: ")
        val autor = pedirDato("autor del elemento: ")
        val fechaDePublicacion = pedirDato("fecha de publicacion del elemento: ")
        val tematica = pedirDato("tematica del elemento: ")
        return Libro(id, titulo, autor, fechaDePublicacion, tematica, EstadoLibro.DISPONIBLE)
    }

    fun pedirDato(mensaje: String): String {
        print(mensaje)
        var opcion: String
        do {
            opcion = readln()
        } while (opcion.isEmpty())
        return opcion
    }

    fun mostrarMensajeAUsuario(mensaje: String) {
        println(mensaje)
    }
}