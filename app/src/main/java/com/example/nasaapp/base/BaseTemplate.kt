package com.example.nasaapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseTemplate {

    abstract class BaseActivity: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(getXMLLayout())
            initValues(savedInstanceState)
            initListeners()
        }

        abstract fun initValues(savedInstanceState: Bundle?)
        abstract fun initListeners()
        abstract fun getXMLLayout(): Int
    }

    abstract class BaseFragment: Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(getXMLLayout(), container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            initValues()
            initListeners()
        }

        abstract fun getXMLLayout() : Int
        abstract fun initValues()
        abstract fun initListeners()
    }
}