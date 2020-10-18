package com.example.nasaapp.scenes.list

import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: BaseTemplate.BaseFragment() {

    companion object {
        fun getNewInstance() = ListFragment()
    }

    override fun getXMLLayout(): Int {
        return R.layout.fragment_list
    }

    override fun initValues() {
        TODO("Not yet implemented")
    }

    override fun initListeners() {
        search_button.setOnClickListener {
            viewModel.getPatentsAbout(search_text.text)
        }
    }
}