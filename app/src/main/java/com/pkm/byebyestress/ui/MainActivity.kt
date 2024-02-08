package com.pkm.byebyestress.ui

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pkm.byebyestress.R
import com.pkm.byebyestress.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      val drawable = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_camera, null)
      drawable?.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
      actionBar?.setHomeAsUpIndicator(drawable)


      val navView: BottomNavigationView = binding.navView

      val navController = findNavController(R.id.nav_host_fragment_activity_main)
//      val appBarConfiguration = AppBarConfiguration.Builder(
//         setOf(
//            R.id.navigation_home,
//            R.id.navigation_stress_tes,
//            R.id.navigation_chat,
//            R.id.navigation_profile
//         )
//      ).build()

//      setupActionBarWithNavController(navController, appBarConfiguration)
      navView.setupWithNavController(navController)
   }
}