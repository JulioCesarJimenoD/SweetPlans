package ucne.edu.sweetplans.ui.navegation


sealed class Screen(
    val route: String
){
    object RegistroUsuarios: Screen("RegistroUsuariosScreen")
    object LoginScreen: Screen("LoginScreen")

}
