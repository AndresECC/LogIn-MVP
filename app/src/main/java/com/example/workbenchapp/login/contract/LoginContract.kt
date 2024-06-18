package com.example.workbenchapp.login.contract

interface LoginContract {

    interface LoginPresenter{
        fun login(user:String, password:String)
    }

    interface LoginView{
        fun showSuccess(message: String)
        fun showError(message: String)
        fun showEmpty(message:String)
    }

}