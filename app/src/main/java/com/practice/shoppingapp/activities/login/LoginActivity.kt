package com.practice.shoppingapp.activities.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.practice.shoppingapp.activities.home.HomeActivity
import com.practice.shoppingapp.activities.signup.SignUpActivity
import com.practice.shoppingapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding : ActivityLoginBinding by lazy {
       ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.rootLoginAct)

        binding.apply {
            mtvNoAccount.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

            mbLogin.setOnClickListener {
                this@LoginActivity.getSharedPreferences("auth", Context.MODE_PRIVATE)
                    .edit { putBoolean("isAuthenticated", true) }
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            }
        }
    }
}