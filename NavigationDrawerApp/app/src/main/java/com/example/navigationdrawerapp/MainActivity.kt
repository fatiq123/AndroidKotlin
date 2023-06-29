package com.example.navigationdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle  // this line is must for the toggleBar

    // initialize the drawer layout
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // functionality for the nav drawer items
        val navView: NavigationView = findViewById(R.id.navView)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true

            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment(), it.title.toString())
                }

                R.id.message -> {
                    replaceFragment(MessageFragment(), it.title.toString())
                }

                R.id.settings -> {
                    replaceFragment(SettingsFragment(), it.title.toString())
                }

                R.id.login -> {
                    replaceFragment(LoginFragment(), it.title.toString())
                }

            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.frameLayout, fragment)
            .commit()


        drawerLayout.closeDrawers()
        setTitle(title)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}