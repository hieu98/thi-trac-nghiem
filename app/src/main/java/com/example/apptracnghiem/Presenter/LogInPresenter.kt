package com.example.apptracnghiem.Presenter

import com.example.apptracnghiem.LogInActivity
import com.example.apptracnghiem.Model.User
import com.example.apptracnghiem.Util.LoginRepository
import com.example.apptracnghiem.Util.OperationCallback
import com.example.apptracnghiem.View.LoginContract

class LogInPresenter(val view: LoginContract.View, val repository:LoginRepository):LoginContract.Presenter  {
    init {
        view.presenter =this
    }

    override fun logIn() {
        if (view.validateForm()){
            view.showLoadingView()
            repository.logIn(view.emailField(), view.passwordField(), object : OperationCallback{
                override fun onError(obj: Any?) {
                    view.hideLoadingView()
                    obj?.let {
                        if(it is String){
                            view.showError(it)
                        }
                    }?:kotlin.run {
                        view.showError("Đã xảy ra lỗi")
                    }
                }

                override fun onSuccess(obj: Any?) {
                    view.hideLoadingView()
                    obj?.let {
                        if(it is User){
                            view.goToMainView(it)
                        }
                    }
                }
            })
        }else{

        }
    }
}