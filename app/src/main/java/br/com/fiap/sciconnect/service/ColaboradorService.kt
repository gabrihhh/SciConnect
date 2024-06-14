package br.com.fiap.sciconnect.service

import br.com.fiap.sciconnect.model.Documento
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ColaboradorService {

    //Retorna documentos pendentes de avaliação
    @GET("avaliacao/pendentes")
    fun getDocumentosPendentes(): Call<List<Documento>>

    //Atualiza os documentos segundo avaliação
    @Headers("Content-Type: application/json")
    @PUT("avaliacao/{id_identificadorDocumento}")
    fun putDocumentoVerificado(@Path("id_identificadorDocumento") idDocumento: Int, @Query("documentoVerificado") documentoVerificado: String?): Call<Documento>
}