package br.com.zapgroup.repository

interface MainRepository {
    suspend fun getList(): List<Any>
}