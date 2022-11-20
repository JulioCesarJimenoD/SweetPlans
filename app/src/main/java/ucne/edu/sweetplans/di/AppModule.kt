package ucne.edu.sweetplans.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ucne.edu.sweetplans.data.SweetPlansDb
import ucne.edu.sweetplans.data.dao.UsuarioDao
import ucne.edu.sweetplans.data.repository.UsuarioRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideUsuarioDd(@ApplicationContext context: Context): SweetPlansDb {
        val DATABASE_NAME = "SweetPlansDb"
        return Room.databaseBuilder(
            context,
            SweetPlansDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()

    }
    @Provides
    fun providesUsuarioDao(sweetPlansDb: SweetPlansDb): UsuarioDao {
        return sweetPlansDb.usuarioDao
    }
    /*@Provides
    fun providesUsuarioRepository(usuarioDao: UsuarioDao): UsuarioRepository {
        return UsuarioRepository(usuarioDao)
    }*/


    /*fun provideDatabase(@ApplicationContext context: Context) : AgendaDatabase{
        return Room.databaseBuilder(
            context,
            AgendaDatabase::class.java,"Agenda.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }*/

}