class GestorDeBiblioteca(val catalogo: MutableList<Libro>, val interfazDeUsuario: InterfazDeUsuario) {
    fun buscarElemento(): Libro? {
        val titulo = interfazDeUsuario.pedirDato("titulo del elemento: ")
        val elemento = catalogo.find { it.titulo == titulo }
        return elemento
    }

    fun agregarElemento() {
        val elemento = interfazDeUsuario.accionAgregarElemento()
        if ((catalogo.find { it.titulo == elemento.titulo }) == null) {
            catalogo.add(elemento)
            interfazDeUsuario.mostrarMensajeAUsuario("elemento agregado correctamente")
        } else {
            interfazDeUsuario.mostrarMensajeAUsuario("el elemento ya existe")
        }
    }
    fun eliminarElemento() {
        val elemento = buscarElemento()
        if (elemento != null) {
            catalogo.remove(elemento)
            interfazDeUsuario.mostrarMensajeAUsuario("elemento eliminado correctamente")
        } else {
            interfazDeUsuario.mostrarMensajeAUsuario("el elemento no existe")
        }
    }
    fun prestarElemento() {
        val elemento = buscarElemento()
        if ((elemento != null) && (elemento.estado == EstadoLibro.DISPONIBLE)) {
            elemento.estado = EstadoLibro.RESERVADO
            interfazDeUsuario.mostrarMensajeAUsuario("elemento prestado correctamente")
        } else {
            interfazDeUsuario.mostrarMensajeAUsuario("el elemento no existe o ya ha sido prestado")
        }
    }
    fun devolverElemento() {
        val elemento = buscarElemento()
        if ((elemento != null) && (elemento.estado == EstadoLibro.RESERVADO)) {
            elemento.estado = EstadoLibro.DISPONIBLE
            interfazDeUsuario.mostrarMensajeAUsuario("elemento devuelto correctamente")
        } else {
            interfazDeUsuario.mostrarMensajeAUsuario("el elemento no existe o ya ha sido devuelto")
        }
    }
    fun consultarElemento() {
        val elemento = buscarElemento()
        if (elemento != null) {
            if (elemento.estado == EstadoLibro.DISPONIBLE) {
                interfazDeUsuario.mostrarMensajeAUsuario("estado del elemento: ${EstadoLibro.DISPONIBLE}")
            } else {
                interfazDeUsuario.mostrarMensajeAUsuario("estado del elemento: ${EstadoLibro.RESERVADO}")
            }
        } else {
            interfazDeUsuario.mostrarMensajeAUsuario("el elemento no existe")
        }
    }
    fun mostrarElementos() {
        for (elemento in catalogo) {
            println("${elemento.titulo} - ${elemento.estado}")
        }
    }

}
