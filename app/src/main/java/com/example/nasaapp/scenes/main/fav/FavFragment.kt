package com.example.nasaapp.scenes.main.fav

import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate

class FavFragment: BaseTemplate.BaseFragment() {

    companion object {
        fun getNewInstance() = FavFragment()
    }

    override fun getXMLLayout(): Int {
        return R.layout.fragment_fav
    }

    override fun initValues() {

    }

    override fun initListeners() {

    }
}