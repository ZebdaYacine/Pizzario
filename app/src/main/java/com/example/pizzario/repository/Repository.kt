package com.example.pizzario.repository

import com.example.pizzario.api.RetrofitInstance
import com.example.pizzario.data.model.Post
import com.example.pizzario.data.PostDB as PostDB

class Repository {

    suspend fun getPost():Post{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPosts(db: PostDB):List<Post>{
        val postFromNet=RetrofitInstance.api.getPosts()
        if(postFromNet!= null){
            for (post in postFromNet){
                insertPost(db,post)
            }
        }
        return getPostsFromDb(db)
    }

      private fun getPostsFromDb(db: PostDB): List<Post> {
        val postDB = db.postDao()
        return postDB.getAllPost()
    }

    suspend fun insertPost(db: PostDB,post: Post) {
        val postDB = db.postDao()
        return postDB.insert(post)
    }

}