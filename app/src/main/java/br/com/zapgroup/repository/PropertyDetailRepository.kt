package br.com.zapgroup.repository

import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable

interface PropertyDetailRepository {
    suspend fun getPropertyDetail(id: String): PropertyTable
}