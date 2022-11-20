package ucne.edu.sweetplans.data.repository

import ucne.edu.sweetplans.data.SweetPlansDb
import ucne.edu.sweetplans.model.Usuario
import javax.inject.Inject


class UsuarioRepository @Inject constructor(
    val db: SweetPlansDb
) {
    suspend fun Insertar(usuario: Usuario)=db.usuarioDao.Insertar(usuario)

    fun Lista()= db.usuarioDao.Lista()

}