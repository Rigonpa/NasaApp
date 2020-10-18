package com.example.nasaapp.scenes.main

import android.os.Bundle
import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import com.example.nasaapp.scenes.fav.FavFragment
import com.example.nasaapp.scenes.list.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseTemplate.BaseActivity() {

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

    override fun getXMLLayout(): Int {
        return R.layout.activity_main
    }

    override fun initValues(savedInstanceState: Bundle?) {
        title = "NASA patents"

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_container, listFragment)
                    .commit()
        }
    }

    override fun initListeners() {
        navigation_bar.setOnNavigationItemSelectedListener (navListener)
    }
}