package br.com.zapgroup.viewmodel

import androidx.lifecycle.*
import br.com.zapgroup.api.MainApi
import br.com.zapgroup.repository.MainRepository
import br.com.zapgroup.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel(private val repository: MainRepository): ViewModel() {
    fun getList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getList()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}