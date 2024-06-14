package br.com.fiap.sciconnect.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://192.168.1.105:8080/cienceFinder/startUp/v1/"
//    private val URL = "http://SEU_IP_AQUI:8080/cienceFinder/startUp/v1/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getUsersService(): UserService{
        return retrofitFactory.create(UserService::class.java)
    }

    fun getPostService(): PostService{
        return retrofitFactory.create(PostService::class.java)
    }

    fun getLoginService(): LoginService{
        return retrofitFactory.create(LoginService::class.java)
    }

    fun getHomeService(): HomeService{
        return retrofitFactory.create(HomeService::class.java)
    }

    fun getColaboradorService(): ColaboradorService{
        return retrofitFactory.create(ColaboradorService::class.java)
    }

}
