package br.com.fiap.sciconnect.model

import java.time.LocalDate.now

data class User(
    var idEstudante: Int = 0,
    var documentoEstudante: String = "",
    var nomeEstudante: String = "",
    var areaInteresse: String = "",
    var senhaEstudante: String = "",
    var tipoUsuario: String = "",
    var ultimoLogin: String = now().toString()
)

data class UserLogin(
    var login: String = "",
    var senha: String = ""
)