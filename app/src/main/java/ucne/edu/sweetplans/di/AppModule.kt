package ucne.edu.sweetplans.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ucne.edu.sweetplans.data.AgendaDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides

    fun provideDatabase(@ApplicationContext context: Context) : AgendaDatabase{
        return Room.databaseBuilder(
            context,
            AgendaDatabase::class.java,"Agenda.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}