package com.practice.shoppingapp.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.ActivityHomeBinding
import com.practice.shoppingapp.extension.setupWithNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private val binding : ActivityHomeBinding by  lazy {
       ActivityHomeBinding.inflate(layoutInflater)
    }

    private var currentNavController: LiveData<NavController>? = null
    private var backPressedOnce = false
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

        }

        setupBottomNavigationBar()
    }
    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.home_nav_graph,
            R.navigation.wishlist_nav_graph,
            R.navigation.cart_nav_graph,
            R.navigation.profile_nav_graph
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.btmNaviView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.mainFCV,
            intent = intent
        )
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
    override fun onBackPressed() {
        if (currentNavController?.value?.graph?.startDestinationId == currentNavController?.value?.currentDestination?.id) {
            if (backPressedOnce) {
                super.onBackPressed()
                return
            }
            backPressedOnce = true
            Toast.makeText(applicationContext, "back press again to exit", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                delay(2000)
                backPressedOnce = false
            }
        } else {
            super.onBackPressed()
        }
    }
    fun hideShowBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFCV) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment || destination.id == R.id.wishListFragment
                || destination.id == R.id.cartFragment || destination.id == R.id.profileFragment) {
               binding.btmNaviView.visibility = View.VISIBLE
            } else {
               binding.btmNaviView.visibility = View.GONE
            }
        }
    }
}