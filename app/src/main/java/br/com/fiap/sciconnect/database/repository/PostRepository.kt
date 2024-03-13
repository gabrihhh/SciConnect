package br.com.fiap.sciconnect.database.repository

import android.content.Context
import br.com.fiap.sciconnect.database.dao.PostDb
import br.com.fiap.sciconnect.model.Post

class PostRepository (context: Context){

    var db = PostDb.getDataBase(context).postDao()

    fun salvar(post: Post): Long{
        return db.salvar(post = post)
    }

    fun listarPosts(): List<Post>{
        return db.listarPosts()
    }


}