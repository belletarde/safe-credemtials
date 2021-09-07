package br.com.safeguardian.repository


import br.com.safeguardian.data.CredentialsDao
import br.com.safeguardian.model.db.CredentialsTable

class CredentialsListRepositoryImpl(private val db: CredentialsDao) : CredentialsListRepository {

    override suspend fun getListOfCredentials(): List<CredentialsTable> {
        return db.getListOfCredentials()
    }

    override suspend fun getCredentials(id: Long): CredentialsTable {
        return db.getById(id)
    }

    override suspend fun deleteCredentialItem(id: Long): Int {
        return db.deleteByUserId(id)
    }

    override suspend fun saveCredential(credential: CredentialsTable): Long {
        return db.saveCredential(credential)
    }

    override suspend fun updateCredential(credential: CredentialsTable): Int {
        return db.updateCredential(
            password = credential.password,
            login = credential.login,
            description = credential.description,
            id = credential.id
        )
    }
}