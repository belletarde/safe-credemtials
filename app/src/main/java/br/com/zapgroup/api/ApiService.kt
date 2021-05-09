package br.com.zapgroup.api

import retrofit2.http.GET

interface ApiService {

    @GET("sources/source-1.json")
    suspend fun getAll(): List<Any>

}