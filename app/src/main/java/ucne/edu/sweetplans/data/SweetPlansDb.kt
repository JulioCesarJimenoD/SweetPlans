package ucne.edu.sweetplans.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ucne.edu.sweetplans.data.dao.RegistroAgendaDao
import ucne.edu.sweetplans.data.dao.UsuarioDao
import ucne.edu.sweetplans.model.Actividad
import ucne.edu.sweetplans.model.RegistroAgenda
import ucne.edu.sweetplans.model.Usuario
import ucne.edu.sweetplans.ui.registroAgenda.RegistroAgenda

@Database(
    entities = [Usuario ::class , RegistroAgenda :: class],
    exportSchema = false,
    version = 1
)
abstract class SweetPlansDb : RoomDatabase() {
    abstract val usuarioDao: UsuarioDao
    abstract val RegistroAgendaDao : RegistroAgendaDao
}



