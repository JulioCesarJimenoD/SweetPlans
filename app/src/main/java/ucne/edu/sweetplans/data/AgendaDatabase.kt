package ucne.edu.sweetplans.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ucne.edu.sweetplans.data.dao.RegistroAgendaDao
import ucne.edu.sweetplans.model.RegistroAgenda

@Database(
    entities = [RegistroAgenda:: class],
    exportSchema = false,
    version = 2
)

abstract class AgendaDatabase : RoomDatabase() {

    abstract val RegistroAgendaDao : RegistroAgendaDao
}