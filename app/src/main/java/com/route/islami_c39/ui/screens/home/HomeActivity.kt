package com.route.islami_c39.ui.screens.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.route.islami_c39.R
import com.route.islami_c39.databinding.ActivityHomeBinding
import com.route.islami_c39.ui.screens.home.fragments.ahadeth.AhadethFragment
import com.route.islami_c39.ui.screens.home.fragments.quran.QuranFragment
import com.route.islami_c39.ui.screens.home.fragments.radio.RadioFragment
import com.route.islami_c39.ui.screens.home.fragments.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(QuranFragment())
        initListeners()
    }
    private fun initListeners(){
        binding.bottomNav.setOnItemSelectedListener{
            if(it.itemId == R.id.icQuran){
                startFragment(QuranFragment())
            }else if(it.itemId == R.id.icAhadeth){
                startFragment(AhadethFragment())
            }else if(it.itemId == R.id.icSebha){
                startFragment(SebhaFragment())
            }else if(it.itemId == R.id.icRadio){
                startFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
    }
   private fun startFragment(fragment: Fragment){
       supportFragmentManager.beginTransaction()
           .replace(R.id.fragmentContainer, fragment)
           .commit()
    }
}