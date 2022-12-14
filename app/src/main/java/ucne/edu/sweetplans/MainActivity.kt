package ucne.edu.sweetplans

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ucne.edu.sweetplans.ui.Inicio.IncioScreen
import ucne.edu.sweetplans.ui.Login.LoginScreen
import ucne.edu.sweetplans.ui.Login.RegistroUsiario
import ucne.edu.sweetplans.ui.navegation.Home
import ucne.edu.sweetplans.ui.navegation.Screen
import ucne.edu.sweetplans.ui.registroAgenda.ConsultaScreen
import ucne.edu.sweetplans.ui.registroAgenda.RegistroAgendaScreen
import ucne.edu.sweetplans.ui.theme.SweetPlansTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweetPlansTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    inicio(navController)


                }
            }
        }
    }
}




@Composable
private fun inicio(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.LoginScreen.route){

        composable(Screen.LoginScreen.route){
            LoginScreen(navHostController)
        }

        composable(Screen.Home.route){
            Home(navHostController)
        }

        composable(Screen.RegistroUsuarios.route){
            RegistroUsiario(navHostController)
        }


    }
}