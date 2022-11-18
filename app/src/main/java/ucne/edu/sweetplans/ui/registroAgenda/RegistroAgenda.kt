package ucne.edu.sweetplans.ui.registroAgenda

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import ucne.edu.sweetplans.R
import ucne.edu.sweetplans.ui.navegation.navegation
import java.lang.reflect.Modifier


@Preview(showBackground = true, showSystemUi = true)
@Composable

fun RegistroAgenda(){

    var date by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registrar Tarea")},
            )
        },
        content = {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                AndroidView(factory = { CalendarView(it) }, update = {
                    it.setOnDateChangeListener {CalendarView,year,moth, day ->
                        date = "$day - ${moth + 1} - $year"
                    }
                })
                Text(date)

                Column {
                    OutlinedTextField(
                        value = "",
                        label = { Text(text = "Nombre") },
                        onValueChange = { },
                    )
                    Spacer(modifier = androidx.compose.ui.Modifier.padding(10.dp))
                    OutlinedTextField(
                        value = "",
                        label = { Text(text = "Descripción") },
                        onValueChange = {}
                    )
                }
                navegation()

            }
        }
    )
}