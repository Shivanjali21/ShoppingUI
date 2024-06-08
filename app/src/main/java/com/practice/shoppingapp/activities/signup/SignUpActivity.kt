package com.practice.shoppingapp.activities.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import com.google.android.material.button.MaterialButton
import com.practice.shoppingapp.R
import com.practice.shoppingapp.activities.home.HomeActivity
import com.practice.shoppingapp.activities.login.LoginActivity
import com.practice.shoppingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val binding : ActivitySignUpBinding by lazy {
       ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.rootSignUpRoot)

        binding.apply {

            mtvNoAccountLogin.setOnClickListener {
                //findNavController().navigate(R.id.action_signUpFragment_to_loginInFragment)
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            }

            mbSignUp.setOnClickListener {
                this@SignUpActivity
                    .getSharedPreferences("auth", Context.MODE_PRIVATE)
                    .edit { putBoolean("isAuthenticated", true) }

                val md = AlertDialog.Builder(applicationContext, R.style.Theme_CustomMaterialAlert).create()
                val customLayout: View = layoutInflater.inflate(R.layout.layout_custom_dialog, null)
                val btnDone = customLayout.findViewById<MaterialButton>(R.id.mBtnDone)
                btnDone.setOnClickListener {
                    md.dismiss()
//                    findNavController().navigate(R.id.action_signUpFragment_to_homeFragment, null, navOptions{
//                        popUpTo(R.id.auth_nav_graph)
//                    })
                    startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                }
                md.setView(customLayout)
                md.setCanceledOnTouchOutside(false)
                md.show()
            }
        }
    }
}