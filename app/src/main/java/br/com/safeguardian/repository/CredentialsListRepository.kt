package br.com.safeguardian.repository

import br.com.safeguardian.model.db.CredentialsTable

interface CredentialsListRepository {
    suspend fun getListOfCredentials(): List<CredentialsTable>

    suspend fun getCredentials(id: Long): CredentialsTable

    suspend fun deleteCredentialItem(id: Long): Int

    suspend fun saveCredential(credential: CredentialsTable): Long

    suspend fun updateCredential(credential: CredentialsTable): Int
}