package com.pkm.byebyestress.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pkm.byebyestress.R
import com.pkm.byebyestress.ui.MainActivity

class SplashScreen : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_splash_screen)

      val splashThread = object : Thread() {
         override fun run() {
            try {
               sleep(3000)
            } catch (e: InterruptedException) {
               e.printStackTrace()
            } finally {
               val intent = Intent(applicationContext, MainActivity::class.java)
               startActivity(intent)
               finish()
            }
         }
      }
      splashThread.start()
   }
}