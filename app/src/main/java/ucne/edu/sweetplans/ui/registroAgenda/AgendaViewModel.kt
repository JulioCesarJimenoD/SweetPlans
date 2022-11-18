package ucne.edu.sweetplans.ui.registroAgenda

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ucne.edu.sweetplans.data.repository.RegistroAgendaRepository
import javax.inject.Inject

@HiltViewModel
class AgendaViewModel @Inject constructor(
    val registroAgendaRepository: RegistroAgendaRepository
) : ViewModel() {

    var nombreRegistro by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var fecha by mutableStateOf("")
    var data by mutableStateOf("")

    //No validar la fecha

    fun save(){
        // hacer un iuState
        //y hacer una validadcion


    }

}