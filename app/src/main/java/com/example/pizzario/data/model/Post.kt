package com.example.pizzario.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@androidx.room.Entity(tableName = "Post")
@Parcelize
data class Post (
    @PrimaryKey var id: Int,
    val userId:Int,
    val title:String,
    val body :String
    ) : Parcelable