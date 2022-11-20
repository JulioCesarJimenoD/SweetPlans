package ucne.edu.sweetplans.data.repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.sweetplans.data.SweetPlansDb
import ucne.edu.sweetplans.model.RegistroAgenda
import javax.inject.Inject

class RegistroAgendaRepository @Inject constructor(
    val db: SweetPlansDb
) {

    suspend fun Insertar(registroAgenda: RegistroAgenda) =
        db.RegistroAgendaDao.Insertar(registroAgenda)

    fun getList(): Flow<List<RegistroAgenda>> = db.RegistroAgendaDao.gesList()

}