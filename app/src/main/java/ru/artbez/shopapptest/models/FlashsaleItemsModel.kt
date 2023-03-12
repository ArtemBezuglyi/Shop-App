package ru.artbez.shopapptest.models

import androidx.room.PrimaryKey
import java.io.Serializable

data class FlashsaleItemsModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val category: String,

    val name: String,

    val price: Float,

    val discount: Int,

    val image_url: String,

    ) : Serializable