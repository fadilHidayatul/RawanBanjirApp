package com.example.rawanbanjirapp.Intro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rawanbanjirapp.MainActivity
import com.example.rawanbanjirapp.R

class SplashScreenActivity : AppCompatActivity() {
lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val intent = Intent(this, MainActivity::class.java)
        var timer : Thread = object :Thread(){
            override fun run() {
                try {
                    sleep(4500)
                }catch (e : InterruptedException){
                    e.printStackTrace()
                }finally {
                    startActivity(intent)
                    finish()
                }
                super.run()
            }
        }
        timer.start()
    }
}
