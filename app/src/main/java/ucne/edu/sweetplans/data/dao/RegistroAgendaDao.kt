package ucne.edu.sweetplans.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ucne.edu.sweetplans.model.RegistroAgenda

@Dao
interface RegistroAgendaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar (registroAgenda: RegistroAgenda)

    @Query("SELECT * FROM RegistroAgenda ORDER BY registroId")
    fun gesList(): Flow<List<RegistroAgenda>>

    @Delete
    suspend fun Eliminar(registroAgenda: RegistroAgenda)

    @Update
    suspend fun Modificar(registroAgenda: RegistroAgenda)
}