package br.com.fiap.sciconnect.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://localhost:8080/cienceFinder/startUp/v1/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getUsersService(): UserService{
        return retrofitFactory.create(UserService::class.java)
    }

}
