package com.example.nasaapp.scenes.main.list

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import com.example.nasaapp.common.AppViewModelFactory
import com.example.nasaapp.scenes.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: BaseTemplate.BaseFragment() {

    companion object {
        fun getNewInstance() = ListFragment()
    }

    private val mViewModel: MainViewModel by lazy {
        val factory = AppViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    override fun getXMLLayout(): Int {
        return R.layout.fragment_list
    }

    override fun initValues() {

    }

    override fun initListeners() {
        search_button.setOnClickListener {
            mViewModel.getPatentsAbout(search_text.text.toString()).observe(this, Observer {
                if (it != null && it.isNotEmpty()) {
                    print(it)
                } else {
                    // Mostrar popup de que la nasa no tiene patentes de ese elemento, escoja otro elemento:
                    print("No results with that object")
                }
            })
        }
    }
}