package br.com.zapgroup.model.api

data class PricingInfosResponse(
    val yearlyIptu: String,
    val price: String,
    val businessType: String,
    val monthlyCondoFee: String
)
