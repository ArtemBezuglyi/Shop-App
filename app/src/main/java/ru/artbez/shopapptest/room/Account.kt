package ru.artbez.shopapptest.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(

@PrimaryKey(autoGenerate = true)
val id: Int,
val firstName: String,
val lastName: String,
val email: String
)
