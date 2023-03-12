package ru.artbez.shopapptest.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.artbez.shopapptest.MAIN
import ru.artbez.shopapptest.R
import ru.artbez.shopapptest.SharedPref
import ru.artbez.shopapptest.databinding.FragmentProfileBinding
import ru.artbez.shopapptest.room.Account
import ru.artbez.shopapptest.room.AccountDB

class ProfileFragment : Fragment() {

    private var pFrBinding: FragmentProfileBinding ?= null
    private val binding get() = pFrBinding!!

    private lateinit var appDB: AccountDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pFrBinding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pInitial()
    }

    private fun pInitial() {

        appDB = AccountDB.getDatabase(MAIN)

        binding.string7icon.setOnClickListener {
            logOut()
        }
    }

    private fun logOut(){
        val loggedName = SharedPref.getName(MAIN, "loggedName")
        val accountToDel : Account = appDB.accountDao()!!.findByName(loggedName!!)

        appDB.accountDao()!!.deleteAccount(accountToDel)

        SharedPref.delName(MAIN, "loggedName")
        Toast.makeText(MAIN,getString(R.string.logout), Toast.LENGTH_SHORT).show()
        goToSign()
    }

    private fun goToSign(){
        val bundle = Bundle()
        MAIN.navController.navigate(R.id.action_mainFragment_to_signInFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pFrBinding = null
    }

}