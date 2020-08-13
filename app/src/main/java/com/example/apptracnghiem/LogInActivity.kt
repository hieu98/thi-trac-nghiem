package com.example.apptracnghiem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import com.example.apptracnghiem.Model.User
import com.example.apptracnghiem.Presenter.LogInPresenter
import com.example.apptracnghiem.Util.Injection
import com.example.apptracnghiem.View.LoginContract
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity(),LoginContract.View{

    override lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        presenter=LogInPresenter(this,Injection.provideLogInRepository(this))

        btn_login.setOnClickListener {
            presenter.logIn()
        }

        txtDangKi.setOnClickListener{
             val intent = Intent(this, SignUpActivity::class.java)
             startActivity(intent)
       }
    }
    override fun showLoadingView() {
        viewLoading.visibility= View.VISIBLE
    }

    override fun hideLoadingView() {
        viewLoading.visibility= View.GONE
    }

    override fun showError(error: String) {
        Toast.makeText(this, "error $error", Toast.LENGTH_LONG).show()
    }

    override fun userField(): String {
        return ""
    }

    override fun goToMainView(user: User?) {
        val bundle:Bundle= Bundle().apply {
            putSerializable("USER",user?:"")
        }
        Toast.makeText(this,"Đăng nhập thành công",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MainActivity::class.java).putExtras(bundle))
        finish()
    }

    override fun emailField():String {
        return editTextEmail.text.toString()
    }

    override fun passwordField():String {
        return editTextPassword.text.toString()
    }

    override fun validateForm(): Boolean {
        return editTextEmail.text.toString().isNotEmpty() && editTextPassword.text.toString().isNotEmpty()
    }
}