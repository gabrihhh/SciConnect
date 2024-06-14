package br.com.fiap.sciconnect.service

import br.com.fiap.sciconnect.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    //chama endpoint de login
    @Headers("Content-Type: application/json")
    @POST("login")
    fun postLogin(@Body body: User): Call<List<User>>
}