package com.example.apptracnghiem.View

import com.example.apptracnghiem.Model.User

interface LoginContract {
    interface View: BaseView<Presenter>{
        fun showLoadingView()
        fun hideLoadingView()
        fun goToMainView(user:User?)
        fun showError(error:String)
        fun emailField():String
        fun passwordField():String
        fun validateForm():Boolean
    }
    interface Presenter{
        fun logIn()
    }
}