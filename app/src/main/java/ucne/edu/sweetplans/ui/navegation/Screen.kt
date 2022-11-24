package ucne.edu.sweetplans.ui.navegation


sealed class Screen(
    val route: String
){
    object RegistroUsuarios: Screen("RegistroUsuariosScreen")
    object LoginScreen: Screen("LoginScreen")
    object InicioScreen: Screen("InicioScreen")
    object ConsultaScreen: Screen ("ConsultaScreen")
    object RegistroAgendaScreen: Screen("RegistroAgendaScreen")
    object PantallaPruebaScreen: Screen("PantallaPruebaScreen")
    object Navegation: Screen("Navegation")
    object Home: Screen("Home")

}
