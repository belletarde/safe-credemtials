package br.com.zapgroup.api


import br.com.zapgroup.data.PropertyDao
import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable
import br.com.zapgroup.repository.PropertyDetailRepository
import br.com.zapgroup.repository.PropertyListRepository
import br.com.zapgroup.repository.SplashRepository

class PropertyDetailApi(private val db: PropertyDao) : PropertyDetailRepository {

    override suspend fun getPropertyDetail(id: String): PropertyTable {
        return db.getById(id)
    }
}