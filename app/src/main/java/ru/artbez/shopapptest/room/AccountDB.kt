package ru.artbez.shopapptest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Account::class],
    version = 1
)
abstract class AccountDB : RoomDatabase() {

    abstract fun accountDao(): AccountDao?

    companion object {

        private var database: AccountDB? = null

        fun getDatabase(context: Context): AccountDB{
            return if (database == null) {
                database = Room
                    .databaseBuilder(context, AccountDB::class.java, "account")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                database as AccountDB
            } else {
                database as AccountDB
            }
        }
    }
}

