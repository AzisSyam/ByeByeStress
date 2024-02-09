package com.pkm.byebyestress.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pkm.byebyestress.databinding.ActivityLoginBinding
import com.pkm.byebyestress.ui.MainActivity

class LoginActivity : AppCompatActivity() {
   private lateinit var binding: ActivityLoginBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityLoginBinding.inflate(layoutInflater)
      setContentView(binding.root)

      binding.btnLogin.setOnClickListener {
         val intent = Intent(this@LoginActivity, MainActivity::class.java)
         startActivity(intent)
         finish()
      }
   }
}