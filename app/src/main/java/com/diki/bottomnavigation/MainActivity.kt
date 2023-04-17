package com.diki.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.diki.bottomnavigation.fragment.HomeFragment
import com.diki.bottomnavigation.fragment.NotificationFragment
import com.diki.bottomnavigation.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION", "UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notivicationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation= findViewById<BottomNavigationView>(R.id.bottom_navigtion)


        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notivicationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}