package ru.artbez.shopapptest.room

import androidx.room.*

@Dao
interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAccount(account: Account)

    @Query("SELECT EXISTS (SELECT * FROM accounts WHERE firstName = :firstName)")
    fun isTaken(firstName:String): Boolean

    @Query("SELECT * FROM accounts WHERE firstName LIKE :firstName LIMIT 1")
    fun findByName(firstName:String): Account

    @Query("DELETE FROM accounts")
    fun deleteAll()

    @Update
    fun updateAccount(account: Account)

    @Delete
    fun deleteAccount(account: Account)
}