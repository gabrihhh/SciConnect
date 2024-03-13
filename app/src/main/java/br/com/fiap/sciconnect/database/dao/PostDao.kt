package br.com.fiap.sciconnect.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.sciconnect.model.Post
@Dao
interface PostDao {
    @Insert
    fun  salvar(post: Post): Long

    @Query("SELECT * FROM tb_post ORDER BY id")
    fun listarPosts(): List<Post>

//    @Update
//    fun atualizar(post: Post): Int

//    @Delete
//    fun excluir(id: Long): Int

//    @Query
//    fun listarPostPorId(id: Long): Post

}