class Menu() {
    val interfazDeUsuario = InterfazDeUsuario()
    val catalogo = mutableListOf<Libro>()
    val gestorDeBiblioteca = GestorDeBiblioteca(catalogo, interfazDeUsuario)
    fun iniciar() {
        try {
            var opcion: Int
            do {
                opcion = interfazDeUsuario.mostrarMenu()
                when (opcion) {
                    1 -> gestorDeBiblioteca.agregarElemento()
                    2 -> gestorDeBiblioteca.eliminarElemento()
                    3 -> gestorDeBiblioteca.prestarElemento()
                    4 -> gestorDeBiblioteca.devolverElemento()
                    5 -> gestorDeBiblioteca.consultarElemento()
                    6 -> gestorDeBiblioteca.mostrarElementos()
                }
            } while (opcion != 7)
        } catch (_: NumberFormatException) {
            interfazDeUsuario.mostrarMensajeAUsuario("el caracter introducido debe ser de un formato numerico")
        }
    }
}