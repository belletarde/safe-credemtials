package br.com.zapgroup.api


import br.com.zapgroup.data.PropertyDao
import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable
import br.com.zapgroup.repository.MainRepository

class MainApi(private val apiService: ApiService, private val db: PropertyDao) : MainRepository {

    override suspend fun getList(): List<PropertyResponse> {
        return apiService.getAll()
    }

    override suspend fun addPropertyToTable(propertyList: List<PropertyTable>): List<Long> {
        return db.insertAll(propertyList)
    }

    override suspend fun getAnyProperty(): PropertyTable {
        return db.getAnyProperty()
    }
}