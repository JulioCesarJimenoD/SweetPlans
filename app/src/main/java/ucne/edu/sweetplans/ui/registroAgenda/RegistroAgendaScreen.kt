package ucne.edu.sweetplans.ui.registroAgenda

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.ui.navegation.navegation
import java.util.*


//@Preview(showBackground = true, showSystemUi = true)
@Composable

fun RegistroAgendaScreen() {

    val ScaffoldState = rememberScaffoldState()

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Tarea") })
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

           FechaDate(context)

            OutlinedTextField(
                value = "",
                onValueChange = {} ,
                label = { Text(text = "Tarea")},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {} ,
                label = { Text(text = "Descripcion")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp))

            Spacer(modifier = Modifier.padding(10.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Agregar")
            }
            navegation()
        }

    }

}


@Composable

fun FechaDate(context: Context) {
    val año: Int
    val mes: Int
    val dia: Int

    val calendario = Calendar.getInstance()
    año = calendario.get(Calendar.YEAR)
    mes = calendario.get(Calendar.MONTH)
    dia = calendario.get(Calendar.DAY_OF_MONTH)
    calendario.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int
            ->
            date.value = "$dayOfMonth/$month/$year"
        }, año, mes, dia
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(value = date.value, onValueChange = {datePickerDialog},
                label = { Text(text = "Seleciones la fecha")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp))
//
    }
}