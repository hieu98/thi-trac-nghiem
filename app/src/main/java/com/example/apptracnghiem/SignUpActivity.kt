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
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity(),LoginContract.View{

    override lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        ButterKnife.bind(this)
        presenter=LogInPresenter(this,Injection.provideLogInRepository(this))

        btn_signup.setOnClickListener {
            presenter.signUp()
        }

    }
    override fun showLoadingView() {
        viewLoading1.visibility= View.VISIBLE
    }

    override fun hideLoadingView() {
        viewLoading1.visibility= View.GONE
    }

    override fun showError(error: String) {
        Toast.makeText(this, "error $error", Toast.LENGTH_LONG).show()
    }

    override fun goToMainView(user: User?) {
        val bundle:Bundle= Bundle().apply {
            putSerializable("USER",user?:"")
        }
        Toast.makeText(this,"Đăng kí thành công",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MainActivity::class.java).putExtras(bundle))
        finish()
    }

    override fun userField(): String {
        return editTextUserSignup.text.toString()
    }

    override fun emailField():String {
        return editTextEmailSignUp.text.toString()
    }

    override fun passwordField():String {
        return editTextPasswordSignUp.text.toString()
    }

    override fun validateForm(): Boolean {
        return editTextUserSignup.text.isNotEmpty() && editTextEmailSignUp.text.toString().isNotEmpty() && editTextPasswordSignUp.text.toString().isNotEmpty()
    }
}