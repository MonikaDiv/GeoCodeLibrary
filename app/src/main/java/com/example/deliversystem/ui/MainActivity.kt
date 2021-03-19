package com.example.deliversystem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.deliversystem.R

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration.topLevelDestinations.add(R.id.splashFragment)
        appBarConfiguration.topLevelDestinations.add(R.id.deliveryListFragment)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener{ navController: NavController, navDestination: NavDestination, bundle: Bundle? ->

            if(navDestination.id == R.id.splashFragment){
                supportActionBar?.hide()
            }else if(navDestination.id == R.id.deliveryListFragment){
                supportActionBar?.show()
            }

        })
    }
}