package ucne.edu.sweetplans.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "Actividad")
data class Actividad(
    @PrimaryKey(autoGenerate = true)
    val tareaId : Int = 0,
    val descripcion : String,
    val fecha : String,
    val nota : String
)