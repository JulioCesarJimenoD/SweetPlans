package ucne.edu.sweetplans.ui.navegation

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.Login.RegistroUsiario
import ucne.edu.sweetplans.ui.Login.UsuarioViewModel
import ucne.edu.sweetplans.ui.registroAgenda.AgendaViewModel
import ucne.edu.sweetplans.ui.registroAgenda.RegistroAgendaScreen

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun navegation(){


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Modifier.background(colorResource(id = R.color.Verde2))
                /* FAB content */
                Icon(Icons.Filled.Add,
                    contentDescription = "Agregar",
                modifier = Modifier
                    .size(40.dp), tint = androidx.compose.ui.graphics.Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,

        bottomBar = {
            BottomAppBar(
                 cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {


                Spacer(modifier = Modifier.padding(5.dp))

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Home,
                        contentDescription = "Consulta",
                    modifier = Modifier.size(40 .dp))
                }
                Spacer(modifier = Modifier.padding(13.dp))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Notifications,
                        contentDescription = "Lista de pendientes",
                        modifier = Modifier.size(40.dp))
                }

                Spacer(modifier = Modifier.padding(53.dp))

            }
        }
    ) {
        // Screen content
    }

}