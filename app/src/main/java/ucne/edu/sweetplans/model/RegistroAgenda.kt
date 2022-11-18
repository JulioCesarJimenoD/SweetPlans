package ucne.edu.sweetplans.model

import android.widget.DatePicker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegistroAgenda")
data class RegistroAgenda(
    @PrimaryKey(autoGenerate = true)
    val registroId : Int,
    val nombreRegistro : String,
    val descripcion: String,
//    val fecha: DatePicker

)
