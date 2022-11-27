package ucne.edu.sweetplans.ui.navegation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ucne.edu.sweetplans.ui.Inicio.IncioScreen
import ucne.edu.sweetplans.ui.registroAgenda.ConsultaScreen
import ucne.edu.sweetplans.ui.registroAgenda.RegistroAgendaScreen

@Composable
fun Home(navController: NavHostController) {
    val ventanas = listOf(
        Screen.RegistroAgendaScreen,
        Screen.ConsultaScreen,
        Screen.InicioScreen

    )

    Scaffold(
        bottomBar = {
            navegation(ventanas, navController)
        }
    ) {
        MyApp(navController)
    }
}

@Composable
fun MyApp(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.RegistroAgendaScreen.route){

        composable(Screen.RegistroAgendaScreen.route){
            RegistroAgendaScreen()
        }
        composable(Screen.InicioScreen.route){
            IncioScreen(navHostController)
        }

        composable(Screen.RegistroAgendaScreen.route){
            RegistroAgendaScreen()
        }
        composable(Screen.ConsultaScreen.route){
            ConsultaScreen()
        }

        
    }
}