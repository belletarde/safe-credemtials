package br.com.zapgroup.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.zapgroup.model.db.PropertyTable

@Database(entities = [PropertyTable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: PropertyDao
}