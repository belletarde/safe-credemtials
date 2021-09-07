package br.com.zapgroup.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.zapgroup.model.db.CredentialsTable

@Database(entities = [CredentialsTable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: CredentialsDao
}