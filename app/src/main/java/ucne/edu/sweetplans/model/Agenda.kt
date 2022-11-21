package ucne.edu.sweetplans.model

import android.widget.DatePicker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Agendas")
data class Agenda(
    @PrimaryKey(autoGenerate = true)
    val agendaId : Int? = null,
    val nombreAgenda : String,
    val descripcion: String,

//    hacer una variable para trabajar con el datapicker

)
