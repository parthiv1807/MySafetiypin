package com.example.mysafetiypin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomBar.setOnItemReselectedListener { menuItem ->

            if (menuItem.itemId == R.id.nav_guard) {
                inflateFragement(GuardFragment.newInstance())
            }
            else if(menuItem.itemId==R.id.nav_home){
                inflateFragement(HomeFragment.newInstance())
            }

            true
        }
    }

    private fun inflateFragement(newInstance: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }
}