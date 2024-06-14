package br.com.fiap.sciconnect.service

import br.com.fiap.sciconnect.model.Documento
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostService {

//Cadastra documentos (POSTs)
    @Headers("Content-Type: application/json")
    @POST("documento")
    fun postDocumento(@Body body: Documento): Call<Documento>
}