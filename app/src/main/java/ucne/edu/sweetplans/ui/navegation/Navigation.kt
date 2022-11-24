package ucne.edu.sweetplans.ui.navegation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.Login.RegistroUsiario
import ucne.edu.sweetplans.ui.Login.UsuarioViewModel
import ucne.edu.sweetplans.ui.registroAgenda.AgendaViewModel
import ucne.edu.sweetplans.ui.registroAgenda.RegistroAgendaScreen

@Composable
fun navegation(
    items: List<Screen>,
    navController: NavController
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val selected = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (selected.value) 2f else 1f)
    val text = listOf(
        "Registro",
        "Consulta",
//        "ListaPendientes",
//        "InicioScreen"

    )

    val iconos = listOf(
        R.drawable.edit,
        R.drawable.home,
//        R.drawable.pendiente,
//        R.drawable.home
    )
    NavigationBar(
        containerColor = Color.Green,
        tonalElevation = 10.dp
    ){
        Spacer(modifier = Modifier.padding(5.dp))
        items.forEachIndexed { Index, item ->
            NavigationBarItem(
                modifier = Modifier.scale(scale.value),
                icon = {
                       Icon(
                           painter = painterResource(iconos[Index]),
                           contentDescription = null,
                           tint = Color.White
                       )
                },
                label = {Text(text[Index], color = Color.White)},
                selected = currentDestination?.route == item.route,
                onClick = {
                    navController.navigate(item.route)
                }
            )
            Spacer(modifier = Modifier.padding(13.dp))
        }
        Spacer(modifier = Modifier.padding(53.dp))
    }
}