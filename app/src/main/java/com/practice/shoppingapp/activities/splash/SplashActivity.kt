package com.practice.shoppingapp.activities.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.practice.shoppingapp.activities.home.HomeActivity
import com.practice.shoppingapp.activities.login.LoginActivity
import com.practice.shoppingapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding : ActivitySplashBinding by lazy {
       ActivitySplashBinding.inflate(layoutInflater)
    }

    private var splashTimer = 4000 // Splash screen timer in milliseconds
    private val mTimeCounter = object : CountDownTimer(splashTimer.toLong(), 100) {
        override fun onTick(p0: Long) {
            // Not used in this example
        }

        override fun onFinish() {
            val isAuthenticated = this@SplashActivity
                .getSharedPreferences("auth", Context.MODE_PRIVATE)
                .getBoolean("isAuthenticated", false)
            if(isAuthenticated) {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            }
            else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.rootSplashAct)

        mTimeCounter.start()
    }
}