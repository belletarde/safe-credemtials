package br.com.zapgroup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.zapgroup.repository.SplashRepository
import br.com.zapgroup.utils.Resource
import kotlinx.coroutines.Dispatchers

class SplashViewModel(private val repository: SplashRepository): ViewModel() {
    fun setDB() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.addPropertyToTable(repository.getList().map { it.map() })))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getFirstProperty() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getAnyProperty()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}