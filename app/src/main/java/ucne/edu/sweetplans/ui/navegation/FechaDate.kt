package ucne.edu.sweetplans.ui.navegation

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import java.util.*

@Composable
fun FechaDate(context : Context){


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
        context,{_: DatePicker, year: Int, month: Int, dayOfMonth: Int
            -> date.value = "$dayOfMonth/$month/$year"
        },año,mes,dia
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Seleciones la fecha: ${date.value}")

        Button(onClick = { datePickerDialog }) {

        }
    }
}