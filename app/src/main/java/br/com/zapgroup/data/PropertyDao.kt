package br.com.zapgroup.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zapgroup.model.db.PropertyTable

@Dao
interface PropertyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(propertyList: List<PropertyTable>) : List<Long>

    @Query("SELECT * FROM property LIMIT 1")
    suspend fun getAnyProperty() : PropertyTable

    @Query("SELECT * FROM property LIMIT :limit OFFSET :offset")
    suspend fun getVivaList(limit: Int = 10, offset: Int = 1) : List<PropertyTable>

    @Query("SELECT * FROM property LIMIT :limit OFFSET :offset")
    suspend fun getZapList(limit: Int = 10, offset: Int = 1) : List<PropertyTable>

    @Query("SELECT * FROM property Where id = :id")
    suspend fun getById(id: String) : PropertyTable

}

