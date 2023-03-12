package ru.artbez.shopapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.artbez.shopapptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mActBinding: ActivityMainBinding?= null
    private val binding get() = mActBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onDestroy() {
        super.onDestroy()
        mActBinding = null
    }
}