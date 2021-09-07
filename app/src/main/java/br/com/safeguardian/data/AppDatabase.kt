package br.com.safeguardian.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.safeguardian.model.db.CredentialsTable

@Database(entities = [CredentialsTable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: CredentialsDao
}