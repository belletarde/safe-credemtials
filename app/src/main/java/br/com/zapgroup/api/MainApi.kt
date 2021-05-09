package br.com.zapgroup.api


import br.com.zapgroup.repository.MainRepository

class MainApi(private val apiService: ApiService) : MainRepository {

    override suspend fun getList(): List<Any> {
        return apiService.getAll()
    }
}