package ru.artbez.shopapptest

import android.content.Context
import androidx.preference.PreferenceManager

class SharedPref {

    companion object{
        fun setName(context: Context, key: String, value: String){
            val setNameShared = PreferenceManager.getDefaultSharedPreferences(context)
            setNameShared.edit().putString(key, value).apply()
        }

        fun getName(context: Context, key: String): String?{
            val getNameShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getNameShared.getString(key, "")
        }

        fun delName(context: Context, key: String){
            val delNameShared = PreferenceManager.getDefaultSharedPreferences(context)
            delNameShared.edit().remove(key).apply()
        }
    }
}