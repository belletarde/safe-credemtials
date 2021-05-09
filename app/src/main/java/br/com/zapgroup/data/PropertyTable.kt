package br.com.zapgroup.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import br.com.zapgroup.model.PricingInfosResponse
import br.com.zapgroup.model.PropertyAddressResponse

@Entity(tableName = "property")
data class PropertyTable(
    @PrimaryKey
    val id: String,
    val usableAreas: Int
)
