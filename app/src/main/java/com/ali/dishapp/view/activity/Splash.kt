package com.ali.dishapp.view.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.ali.dishapp.R
import com.ali.dishapp.databinding.ActivitySplashBinding


class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_splash)

        splashAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                Toast.makeText(applicationContext, "Hello customers", Toast.LENGTH_SHORT).show()
               }

            override fun onAnimationEnd(animation: Animation?) {
//                val newActive = Intent(this@splash,MainActivity::class.java)

                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@splash, MainActivity::class.java))
                    finish()},
                    500)
              }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        splashBinding.textappMe?.animation  = splashAnimation

        val te = findViewById<TextView>(R.id.textappMe)
        te.startAnimation(splashAnimation)



    }
}