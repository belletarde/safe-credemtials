package br.com.zapgroup.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property")
data class PropertyTable(
    val usableAreas: Int?,
    val listingType: String?,
    val createdAt: String?,
    val listingStatus: String?,
    @PrimaryKey
    val id: String,
    val parkingSpaces: String?,
    val updatedAt: String?,
    val owner: Boolean?,
    val images: String?,
    val city: String?,
    val neighborhood: String?,
    val bathrooms: Int?,
    val bedrooms: Int?,
    val yearlyIptu: String?,
    val price: String?,
    val businessType: String?,
    val monthlyCondoFee: String?
)
