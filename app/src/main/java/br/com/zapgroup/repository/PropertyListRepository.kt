package br.com.zapgroup.repository

import br.com.zapgroup.model.api.PropertyResponse
import br.com.zapgroup.model.db.PropertyTable

interface PropertyListRepository {
    suspend fun getVivaList(): List<PropertyTable>

    suspend fun getZapList(): List<PropertyTable>
}