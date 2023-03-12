package ru.artbez.shopapptest.screens

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.artbez.shopapptest.MAIN
import ru.artbez.shopapptest.R
import ru.artbez.shopapptest.SharedPref
import ru.artbez.shopapptest.databinding.FragmentSignInBinding
import ru.artbez.shopapptest.room.Account
import ru.artbez.shopapptest.room.AccountDB

class SignInFragment : Fragment() {

    private var siFrBinding: FragmentSignInBinding?= null
    private val binding get() = siFrBinding!!

    private lateinit var appDB: AccountDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        siFrBinding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        giInitial()
    }

    private fun giInitial() {

        binding.btnsignin.setOnClickListener {
            dataCheck()
        }

        binding.btnlogin.setOnClickListener {
            goToLogin()
        }

        binding.googleicon.setOnClickListener {
            Toast.makeText(MAIN,getString(R.string.googlelogin), Toast.LENGTH_SHORT).show()
            goToPage()
        }

        binding.appleicon.setOnClickListener {
            Toast.makeText(MAIN,getString(R.string.applelogin), Toast.LENGTH_SHORT).show()
            goToPage()
        }

    }

    private fun dataCheck() {
        appDB = AccountDB.getDatabase(MAIN)

        if ((binding.firstnamesign.text.toString() == "") || (binding.lastname.text.toString() == "")) {
            Toast.makeText(MAIN,getString(R.string.emptyfields), Toast.LENGTH_SHORT).show()
        }
        else
            if (TextUtils.isEmpty(binding.email.text) || (!(Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches())))
                Toast.makeText(MAIN,getString(R.string.incorrectemail), Toast.LENGTH_SHORT).show()
            else {
                dbCheck()
            }
    }

    private fun dbCheck() {
        val firstName = binding.firstnamesign.text.toString()
        if (!(appDB.accountDao()!!.isTaken(firstName))) {
            SharedPref.setName(MAIN, "loggedName", firstName)
            val newAccount = Account(0, binding.firstnamesign.text.toString(), binding.lastname.text.toString(), binding.email.text.toString())
            appDB.accountDao()!!.addAccount(newAccount)
            goToPage()
            Toast.makeText(MAIN,"Welcome, $firstName!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(MAIN,"User name $firstName already taken", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToLogin(){
        val bundle = Bundle()
        MAIN.navController.navigate(R.id.action_signInFragment_to_logInFragment, bundle)
    }

    private fun goToPage() {
        val bundle = Bundle()
        MAIN.navController.navigate(R.id.action_signInFragment_to_mainFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        siFrBinding = null
    }

}