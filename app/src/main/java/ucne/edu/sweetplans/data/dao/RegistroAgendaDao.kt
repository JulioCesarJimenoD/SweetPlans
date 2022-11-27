package ucne.edu.sweetplans.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ucne.edu.sweetplans.model.Agenda

@Dao
interface RegistroAgendaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar (agenda: Agenda)

    @Query("SELECT * FROM Agendas ORDER BY agendaId")
    fun gesList(): Flow<List<Agenda>>

    @Delete
    suspend fun Eliminar(agenda: Agenda)

    @Update
    suspend fun Modificar(agenda: Agenda)


}
