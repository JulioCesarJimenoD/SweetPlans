package ucne.edu.sweetplans.ui.registroAgenda

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ucne.edu.sweetplans.data.repository.AgendaRepository
import ucne.edu.sweetplans.model.Agenda
import javax.inject.Inject



@HiltViewModel
class AgendaViewModel @Inject constructor(
    private val agendaRepository: AgendaRepository

) : ViewModel() {

    var nombreAgenda by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var fecha by mutableStateOf("")
    var agenda = agendaRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch {
            agendaRepository.Insertar(
                Agenda(
                    agendaId = 0,
                    nombreAgenda = nombreAgenda,
                    descripcion = descripcion,
                    fecha = fecha
                )
            )
        }
    }

    fun Eliminar(agenda: Agenda){
        viewModelScope.launch(Dispatchers.IO){
            agendaRepository.Eliminar(agenda)
        }

    }




}