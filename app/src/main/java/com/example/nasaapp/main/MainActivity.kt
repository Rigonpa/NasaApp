package com.example.nasaapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.nasaapp.R
import com.example.nasaapp.fav.FavFragment
import com.example.nasaapp.list.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listFragment = ListFragment.getNewInstance()
    var favFragment = FavFragment.getNewInstance()

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {
            R.id.action_list -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, listFragment)
                        .commit()
                true
            }
            R.id.action_fav -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, favFragment)
                        .commit()
                true
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Patents"

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_container, listFragment)
                    .commit()
        }

        navigation_bar.setOnNavigationItemSelectedListener (navListener)
    }
}