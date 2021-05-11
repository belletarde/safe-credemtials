package br.com.zapgroup.repository

import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable

interface SplashRepository {
    suspend fun getList(): List<PropertyResponse>

    suspend fun addPropertyToTable(propertyList: List<PropertyTable>) : List<Long>

    suspend fun getAnyProperty(): PropertyTable
}