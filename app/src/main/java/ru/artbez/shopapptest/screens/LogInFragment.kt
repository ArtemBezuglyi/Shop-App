package ru.artbez.shopapptest.screens

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.artbez.shopapptest.MAIN
import ru.artbez.shopapptest.R
import ru.artbez.shopapptest.SharedPref
import ru.artbez.shopapptest.databinding.FragmentLogInBinding
import ru.artbez.shopapptest.room.AccountDB

class LogInFragment : Fragment() {

    private var liFrBinding: FragmentLogInBinding?= null
    private val binding get() = liFrBinding!!

    private lateinit var appDB: AccountDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liFrBinding = FragmentLogInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        liInitial()
    }

    private fun liInitial() {

        appDB = AccountDB.getDatabase(MAIN)

        passwordCheck()

        binding.btnlogin.setOnClickListener {
            logCheck()
        }
    }

    private fun passwordCheck() {
        var passwordVisibility = false

        binding.eye.setOnClickListener {
            passwordVisibility = !passwordVisibility
            if (!passwordVisibility) {
                binding.password.transformationMethod = PasswordTransformationMethod()
                binding.eye.setImageResource(R.drawable.baseline_visibility_24)
                binding.password.setSelection(binding.password.length())
            }
            else {
                binding.password.transformationMethod = HideReturnsTransformationMethod()
                binding.eye.setImageResource(R.drawable.baseline_visibility_off_24)
                binding.password.setSelection(binding.password.length())
            }
        }
    }

    private fun logCheck() {
        val firstName = binding.firstnamelog.text.toString()
        if (appDB.accountDao()!!.isTaken(firstName)) {
            SharedPref.setName(MAIN, "loggedName", firstName)
            goToPageFromLogin()
            Toast.makeText(MAIN,"Welcome back, $firstName!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(MAIN,getString(R.string.noaccount), Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToPageFromLogin() {
        val bundle = Bundle()
        MAIN.navController.navigate(R.id.action_logInFragment_to_mainFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        liFrBinding = null
    }

}