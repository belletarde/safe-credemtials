package br.com.safeguardian.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Credentials")
data class CredentialsTable(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    /*User input values*/
    val password: String,
    val login: String?,
    val description: String?,
    /*system values*/
    val createdAt: String,
    val lastView: String,
    val updatedAt: String
)
