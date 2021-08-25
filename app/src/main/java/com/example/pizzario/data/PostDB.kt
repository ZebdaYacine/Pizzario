package com.example.pizzario.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pizzario.data.model.Post


@Database(entities = [Post::class], version = 1, exportSchema = false)

abstract  class PostDB: RoomDatabase() {

    abstract fun postDao(): PostDao

}