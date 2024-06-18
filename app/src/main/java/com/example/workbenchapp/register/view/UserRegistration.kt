package com.example.workbenchapp.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workbenchapp.R
import com.example.workbenchapp.databinding.RegisterPageBinding
import com.example.workbenchapp.login.view.LoginFragment
import com.example.workbenchapp.register.contract.RegistrationContract
import com.example.workbenchapp.register.presenter.RegistrationPresenterImp

class UserRegistration : Fragment(), RegistrationContract.RegisterView {

    private val presenter: RegistrationPresenterImp = RegistrationPresenterImp(this)
    private lateinit var binding:RegisterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterPageBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        regstryEntry()

    }

    private fun regstryEntry(){
        binding.regBtn.setOnClickListener{
            val newName = binding.newUserField.text.toString()
            val newPass = binding.newUserPW.text.toString()
            //val birthDay = binding.birthDate.number.toLong()
            presenter.registry(newName,newPass)
        }
    }

    override fun showSuccess(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        val returnfragment = LoginFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentView, returnfragment)?.commit()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showAlert(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}