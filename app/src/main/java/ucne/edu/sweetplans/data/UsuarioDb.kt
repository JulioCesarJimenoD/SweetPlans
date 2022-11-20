package ucne.edu.sweetplans.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ucne.edu.sweetplans.data.dao.UsuarioDao
import ucne.edu.sweetplans.model.Usuario

@Database(
    entities = [
        Usuario ::class],
    exportSchema = false,
    version = 1
)
abstract class UsuarioDb : RoomDatabase() {
    abstract val usuarioDao: UsuarioDao
}