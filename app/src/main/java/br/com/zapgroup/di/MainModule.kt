package br.com.zapgroup.di

import br.com.zapgroup.api.ApiService
import br.com.zapgroup.api.MainApi
import br.com.zapgroup.repository.MainRepository
import br.com.zapgroup.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val mainModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val repositoryModule = module {
    fun provideUserRepository(api: ApiService): MainRepository {
        return MainApi(api)
    }

    single { provideUserRepository(get()) }
}

val serviceModule = module {
    fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideUserApi(get()) }
}

val netModule = module {

    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return builder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}