package com.example.android.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.android.R
import com.example.android.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var navhostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navhostFragment.navController
        appBarConfiguration = AppBarConfiguration(setOf(R.id.a, R.id.b, R.id.c, R.id.d, R.id.e), binding.drawerLayout)

        binding.materialtoolbar.setupWithNavController(navController, appBarConfiguration)

        binding.materialtoolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profileFragment -> {
                    menuItem.onNavDestinationSelected(navController)  // Değişiklik burada
                    true
                }
                R.id.settingsFragment -> {
                    menuItem.onNavDestinationSelected(navController)  // Değişiklik burada
                    true
                }
                else -> false
            }
        }


// Yerine bunu ekleyin:
        binding.navigationView.setNavigationItemSelectedListener { menuItem->
            menuItem.onNavDestinationSelected(findNavController(R.id.fragmentContainerView2))
            binding.drawerLayout.close()
            true
        }



        binding.bottomNavigationView.setupWithNavController(navController)

            navController.addOnDestinationChangedListener(object:NavController.OnDestinationChangedListener{
                override fun onDestinationChanged(
                    controller: NavController,
                    destination: NavDestination,
                    arguments: Bundle?
                ) {
                    if(destination.id== R.id.profileFragment){

                    }
                    if(destination.id== R.id.settingsFragment){
//                        binding.materialtoolbar.visibility= View.GONE
//                        binding.bottomNavigationView.visibility = View.GONE

                    }
                }

            })

    }}
