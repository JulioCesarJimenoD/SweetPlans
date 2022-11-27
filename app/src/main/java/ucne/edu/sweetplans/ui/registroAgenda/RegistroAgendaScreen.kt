package ucne.edu.sweetplans.ui.registroAgenda

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.navegation.navegation
import java.util.*


@Composable
fun RegistroAgendaScreen(
    viewModel: AgendaViewModel = hiltViewModel()
) {

    val ScaffoldState = rememberScaffoldState()
    var validarNombre by remember { mutableStateOf(false)  }
    var validarDescripcion by remember { mutableStateOf(false)}

    val context = LocalContext.current


    val c = Calendar.getInstance()
    val año = c.get(Calendar.YEAR)
    val mes = c.get(Calendar.MONTH)
    val dia = c.get(Calendar.DAY_OF_MONTH)

    var textfecha by remember { mutableStateOf("")}
    val datePickerDialog = DatePickerDialog(
        context,
        { datePicker,year,mon,day ->
            val month = mon + 1
            textfecha = " Fecha: $day - $month - $year"
        },año,mes,dia
    )


    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "Tarea")})
        },


        scaffoldState = ScaffoldState

    )
    {
        it

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Spacer(modifier = Modifier.padding(20.dp))


            Button(onClick = {datePickerDialog.show()},
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )){
                Icon(painter = painterResource(id = R.drawable.calendario),
                    contentDescription = "Fecha",
                    modifier = Modifier.size(ButtonDefaults.IconSize))
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Selecione Fecha")
            }
            //TextField
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(value = viewModel.nombreAgenda,
                onValueChange = {viewModel.nombreAgenda = it},
                label = { Text(text = "Tarea")},
                placeholder = { Text(text = "Tarea")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.padding(15.dp))

            OutlinedTextField(value = viewModel.descripcion, onValueChange = {viewModel.descripcion = it},
                label = { Text(text = "Descripción")},
                placeholder = { Text(text = "Descripción")},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.8f)

            )
            Spacer(modifier = Modifier.padding(10.dp))

            //  Text de las fecha
            Text( text = "${textfecha}", fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.padding(40.dp))
            Button(onClick = {
                validarNombre = viewModel.nombreAgenda.isBlank()
                validarDescripcion = viewModel.descripcion.isBlank()

                if (viewModel.nombreAgenda == ""){
                    Toast.makeText(context, "El nombre no debe estar vacio", Toast.LENGTH_SHORT).show()
                }
                if (viewModel.descripcion == ""){
                    Toast.makeText(context, "La descripción no debe estar vacio", Toast.LENGTH_SHORT).show()
                }

                if(!validarNombre && !validarDescripcion){
                    viewModel.Guardar()
                    Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()


                }else{
                    Toast.makeText(context, " No fue guardado verifica los datos", Toast.LENGTH_SHORT).show()
                }
            },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )){
                Icon(painter = painterResource(id = R.drawable.save),
                    contentDescription = "Guardar tarea",
                    modifier = Modifier.size(ButtonDefaults.IconSize))
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Guardar")
            }
        }
    }
}