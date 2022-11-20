package ucne.edu.sweetplans.data.repository

import ucne.edu.sweetplans.data.UsuarioDb
import ucne.edu.sweetplans.model.Usuario
import javax.inject.Inject


class UsuarioRepository @Inject constructor(
    val db: UsuarioDb
) {
    suspend fun Insertar(usuario: Usuario)=db.usuarioDao.Insertar(usuario)

    fun Lista()= db.usuarioDao.Lista()

}