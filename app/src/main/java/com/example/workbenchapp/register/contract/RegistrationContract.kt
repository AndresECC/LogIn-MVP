package com.example.workbenchapp.register.contract

import android.provider.ContactsContract.CommonDataKinds.Nickname

interface RegistrationContract {

    interface RegistrationPresenter{
        fun registry(newNickname: String, newPassword : String)
    }

    interface RegisterView{
        fun showSuccess (message:String)
        fun showError (message:String)
        fun showAlert (message:String)
    }
}