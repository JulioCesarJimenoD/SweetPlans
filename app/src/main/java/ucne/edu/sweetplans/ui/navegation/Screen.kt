package ucne.edu.sweetplans.ui.navegation


sealed class Screen(
    val route: String
){
    object RegistroUsuarios: Screen("RegistroUsuariosScreen")
    object LoginScreen: Screen("LoginScreen")
    object InicioScreen: Screen("InicioScreen")
    object ConsultaScreen: Screen ("ConsultaScreen")
    object RegistroAgenda: Screen("RegistroAgendaScreen")
    object Navegation: Screen("Navegation")

}
