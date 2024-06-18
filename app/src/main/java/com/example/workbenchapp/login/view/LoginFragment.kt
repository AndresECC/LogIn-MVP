package com.example.workbenchapp.login.view

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workbenchapp.home.view.HomeFragment
import com.example.workbenchapp.R
import com.example.workbenchapp.databinding.FragmentLoginBinding
import com.example.workbenchapp.login.contract.LoginContract
import com.example.workbenchapp.login.presenter.LoginPresenterImp
import com.example.workbenchapp.register.view.UserRegistration

class LoginFragment : Fragment(),LoginContract.LoginView {

    private val presenter:LoginContract.LoginPresenter = LoginPresenterImp(this)
    private lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        loginInitializer()
        regInitializer()
        
    }

    private fun loginInitializer(){

        binding.passField.transformationMethod = PasswordTransformationMethod.getInstance()

        binding.logBtn.setOnClickListener{
            logInFun()
        }

    }

    private fun logInFun() {
        val user = binding.userField.text.toString()
        val password = binding.passField.text.toString()
        presenter.login(user,password)
    }

    override fun showSuccess(message: String) {
        val nextfragment = HomeFragment()
        //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentView, nextfragment)?.commit()
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    override fun showEmpty(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun regInitializer(){
        binding.regBtn.setOnClickListener{
            val registerfragment = UserRegistration()
            //activity?.supportFragmentManager?.beginTransaction()?.add(R.id.fragmentView, registerfragment)?.commit()
            findNavController().navigate(R.id.action_loginFragment_to_userRegistration)
        }

    }

}