package br.com.zapgroup.repository

import br.com.zapgroup.model.PropertyResponse

interface MainRepository {
    suspend fun getList(): List<Any>

    suspend fun addPropertyToTable(propertyList: List<PropertyResponse>) : List<Long>

    suspend fun deleteAll()
}