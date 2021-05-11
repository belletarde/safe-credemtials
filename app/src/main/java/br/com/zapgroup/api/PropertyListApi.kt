package br.com.zapgroup.api


import br.com.zapgroup.data.PropertyDao
import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable
import br.com.zapgroup.repository.PropertyListRepository
import br.com.zapgroup.repository.SplashRepository

class PropertyListApi(private val db: PropertyDao) : PropertyListRepository {

    override suspend fun getVivaList(): List<PropertyTable> {
        return db.getVivaList()
    }

    override suspend fun getZapList(): List<PropertyTable> {
        return db.getZapList()
    }

}