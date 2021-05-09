package br.com.zapgroup.api


import br.com.zapgroup.data.PropertyDao
import br.com.zapgroup.model.PropertyResponse
import br.com.zapgroup.repository.MainRepository

class MainApi(private val apiService: ApiService,) : MainRepository {

    override suspend fun getList(): List<Any> {
        return apiService.getAll()
    }

    override suspend fun addPropertyToTable(propertyList: List<PropertyResponse>): List<Long> {
        return listOf()
    }

    override suspend fun deleteAll() {
    }
}