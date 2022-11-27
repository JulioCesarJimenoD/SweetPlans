package ucne.edu.sweetplans.data.repository

import kotlinx.coroutines.flow.Flow
import ucne.edu.sweetplans.data.SweetPlansDb
import ucne.edu.sweetplans.model.Agenda
import javax.inject.Inject

class AgendaRepository @Inject constructor(
    val db: SweetPlansDb
) {

    suspend fun Insertar(agenda: Agenda) =
        db.RegistroAgendaDao.Insertar(agenda)

    suspend fun Eliminar(agenda: Agenda) = db.RegistroAgendaDao.Eliminar(agenda)

    fun getList(): Flow<List<Agenda>> = db.RegistroAgendaDao.gesList()

}