package ucne.edu.sweetplans.ui.registroAgenda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
 fun ConsultaScreen(
    agendaViewModel: AgendaViewModel = hiltViewModel()
) {

    var viewModel: AgendaViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Lista de tarea") })
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { goToRegistro()}) {
//                Icon(painter = painterResource(id = R.drawable.add),
//                    contentDescription = "RegristroAgenda", Modifier.size(60.dp),
//                    tint = Color.White)
//
//            }
//        }
    )
    {

        val ConsultaAgenda = viewModel.agenda.collectAsState(initial = emptyList())

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ){
            items(ConsultaAgenda.value){
                    agenda ->
                Card(
                    backgroundColor = Color.White,
                    elevation = (2.dp),
                    modifier = Modifier.padding(all = 16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp)
                    ) {
                        Text(text = "Tarea: ${agenda.nombreAgenda}")
                        Text(text = "Descripcion: ${agenda.descripcion}")
                        Text(text = "Fecha:  ${agenda.fecha}")
//                        IconButton(onClick = { viewModel.Eliminar(agenda) })
//                        {
//                            Icon(imageVector = Icons.Filled.Clear,
//                                contentDescription = "Listo",
//                                tint = Color.Red, modifier = Modifier.size(10.dp))
//                        }
                    }
                }
            }
        }
    }
 }


