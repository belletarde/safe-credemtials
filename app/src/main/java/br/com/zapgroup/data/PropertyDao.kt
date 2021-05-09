package br.com.zapgroup.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zapgroup.model.PropertyResponse

@Dao
interface PropertyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(propertyList: List<PropertyResponse>) : List<Long>

    @Query("DELETE FROM property")
    suspend fun deleteAll() : List<Long>

}

