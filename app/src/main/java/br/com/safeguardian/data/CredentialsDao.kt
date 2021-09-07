package br.com.safeguardian.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.safeguardian.model.db.CredentialsTable

@Dao
interface CredentialsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCredential(credentials: CredentialsTable): Long

    @Query("SELECT * FROM Credentials")
    suspend fun getListOfCredentials() : List<CredentialsTable>

    @Query("DELETE FROM Credentials WHERE id = :id")
    suspend fun deleteByUserId(id: Long): Int

    @Query("SELECT * FROM Credentials Where id = :id")
    suspend fun getById(id: Long) : CredentialsTable

    @Query("Update Credentials SET password = :password, login = :login, description = :description Where id = :id")
    suspend fun updateCredential(
        password: String,
        login: String?,
        description: String?,
        id: Long) : Int

}

