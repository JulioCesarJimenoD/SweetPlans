package ucne.edu.sweetplans.ui.registroAgenda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.ui.navegation.navegation

@Composable
 fun ConsultaScreen(
    agendaViewModel: AgendaViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val ConsultaAgenda = agendaViewModel.agenda.collectAsState(initial = emptyList() )

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ){
        items(ConsultaAgenda.value){ agenda ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "${agenda.nombreAgenda}")

                    Text(
                        text = "${agenda.descripcion}",
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }
 }


