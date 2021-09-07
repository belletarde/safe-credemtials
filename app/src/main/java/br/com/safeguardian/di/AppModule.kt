package br.com.safeguardian.di

import android.app.Application
import androidx.room.Room
import br.com.safeguardian.repository.CredentialsListRepositoryImpl
import br.com.safeguardian.data.AppDatabase
import br.com.safeguardian.data.CredentialsDao
import br.com.safeguardian.repository.CredentialsListRepository
import br.com.safeguardian.viewmodel.CredentialsListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainModule = module {
    viewModel {
        CredentialsListViewModel(get())
    }
}

val repositoryModule = module {
    fun providePropertyListRepository(db: CredentialsDao): CredentialsListRepository {
        return CredentialsListRepositoryImpl(db)
    }

    factory { providePropertyListRepository(get()) }
}

val databaseModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
            .build()
    }


    fun provideDao(database: AppDatabase): CredentialsDao {
        return database.userDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}