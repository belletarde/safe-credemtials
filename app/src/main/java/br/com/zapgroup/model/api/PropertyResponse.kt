package br.com.zapgroup.model.api

import br.com.zapgroup.model.db.PropertyTable
import br.com.zapgroup.utils.Mappable

data class PropertyResponse(
    val usableAreas: Int,
    val listingType: String,
    val createdAt: String,
    val listingStatus: String,
    val id: String,
    val parkingSpaces: String,
    val updatedAt: String,
    val owner: Boolean,
    val images: List<String>,
    val address: PropertyAddressResponse,
    val bathrooms: Int,
    val bedrooms: Int,
    val pricingInfos: PricingInfosResponse
): Mappable<PropertyTable?>{
    override fun map(): PropertyTable {
        return PropertyTable(
            usableAreas = usableAreas,
            listingType = listingType,
            createdAt = createdAt,
            listingStatus = listingStatus,
            id = id,
            parkingSpaces = parkingSpaces,
            updatedAt = updatedAt,
            owner = owner,
            images = images.joinToString(separator = "#img#", limit = images.size),
            city = address.city,
            neighborhood = address.neighborhood,
            bathrooms = bathrooms,
            bedrooms = bedrooms,
            yearlyIptu = pricingInfos.yearlyIptu,
            price = pricingInfos.price,
            businessType = pricingInfos.businessType,
            monthlyCondoFee = pricingInfos.monthlyCondoFee
        )
    }
}