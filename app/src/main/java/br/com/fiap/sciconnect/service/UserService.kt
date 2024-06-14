package br.com.fiap.sciconnect.service

import br.com.fiap.sciconnect.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    // cadastra estudantes e colaboradores
    @Headers("Content-Type: application/json")
    @POST("estudante")
    fun postUser(@Body body: User): Call<User>
}