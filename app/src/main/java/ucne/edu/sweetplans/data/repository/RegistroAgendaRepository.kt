package ucne.edu.sweetplans.data.repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.sweetplans.data.AgendaDatabase
import ucne.edu.sweetplans.model.RegistroAgenda
import javax.inject.Inject

class RegistroAgendaRepository @Inject constructor(
    val db: AgendaDatabase
) {

    suspend fun Insertar(registroAgenda: RegistroAgenda) =
        db.RegistroAgendaDao.Insertar(registroAgenda)

    fun getList(): Flow<List<RegistroAgenda>> = db.RegistroAgendaDao.gesList()

}