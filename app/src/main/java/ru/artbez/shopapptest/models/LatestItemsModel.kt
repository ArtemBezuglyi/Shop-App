package ru.artbez.shopapptest.models

import androidx.room.PrimaryKey
import java.io.Serializable

data class LatestItemsModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val category: String,

    val name: String,

    val price: Int,

    val image_url: String,

    ) : Serializable