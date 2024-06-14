package br.com.fiap.sciconnect.service

import br.com.fiap.sciconnect.model.Documento
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {

    //Lista os documentos da home
    @GET("home")
    fun getDocumentosValidos(): Call<List<Documento>>

}