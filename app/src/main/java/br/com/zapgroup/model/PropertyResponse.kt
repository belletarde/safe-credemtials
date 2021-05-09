package br.com.zapgroup.model

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
)

data class PropertyAddressResponse(
    val city: String,
    val neighborhood: String,
    val geoLocation: GeoLocationResponse
)

data class GeoLocationResponse(
    val precision: String,
    val location: PropertyLocationResponse
)

data class PropertyLocationResponse(
    val lon: Double,
    val lat: Double
)

data class PricingInfosResponse(
    val yearlyIptu: String,
    val price: String,
    val businessType: String,
    val monthlyCondoFee: String
)
