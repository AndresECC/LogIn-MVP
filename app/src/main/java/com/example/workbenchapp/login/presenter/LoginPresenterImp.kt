package com.example.workbenchapp.login.presenter

import android.widget.Toast
import com.example.workbenchapp.R
import com.example.workbenchapp.data.DummyDB
import com.example.workbenchapp.home.view.HomeFragment
import com.example.workbenchapp.login.contract.LoginContract
import com.example.workbenchapp.login.contract.LoginContract.LoginPresenter

class LoginPresenterImp(private val loginView: LoginContract.LoginView) : LoginPresenter {
    val database = DummyDB
    override fun login(user: String, password: String) {
        if (user.isEmpty() or password.isEmpty()) {
            loginView.showEmpty("One or more fields are empty!")
        } else {
            val currentuser = database.getUser(user)
            if (currentuser != null) {
                if (currentuser.password == password) {
                    loginView.showSuccess("Credentials Validated")
                }else{
                    loginView.showError("Wrong credentials!")
                }
            }else{
                loginView.showEmpty("Error 404: User not found!")
            }
        }
    }
}
