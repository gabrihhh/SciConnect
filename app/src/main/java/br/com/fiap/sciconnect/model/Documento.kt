package br.com.fiap.sciconnect.model

data class Documento(
    var idDocumento: Int = 0,
    var autor: String = "",
    var areaEstudoDocumento: String = "",
    var nomeDocumento: String = "",
    var propostaEstudo: String = "",
    var documentoVerificado: String = ""
)
