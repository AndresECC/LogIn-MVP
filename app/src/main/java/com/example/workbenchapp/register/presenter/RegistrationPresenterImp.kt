package com.example.workbenchapp.register.presenter

import com.example.workbenchapp.data.DummyDB
import com.example.workbenchapp.model.User
import com.example.workbenchapp.register.contract.RegistrationContract

class RegistrationPresenterImp(private val RegisterView: RegistrationContract.RegisterView): RegistrationContract.RegistrationPresenter {
    //private val database = DummyDB
    override fun registry(newNickname: String, newPassword: String){
        val newName = User(newNickname, newPassword)
        DummyDB.addUser(newName)
        RegisterView.showSuccess("si funca")
    }

}