package br.com.zapgroup.api

import br.com.zapgroup.model.PropertyResponse
import retrofit2.http.GET

interface ApiService {

    @GET("sources/source-1.json")
    suspend fun getAll(): List<PropertyResponse>

}