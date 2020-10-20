package com.example.nasaapp.scenes.main.fav

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import com.example.nasaapp.common.AppViewModelFactory
import com.example.nasaapp.data.model.Patent
import com.example.nasaapp.scenes.main.MainViewModel
import com.example.nasaapp.scenes.main.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.android.synthetic.main.fragment_fav.recycler_view
import kotlinx.android.synthetic.main.fragment_list.*

class FavFragment: BaseTemplate.BaseFragment() {

    private val mViewModel: MainViewModel by lazy {
        val factory = AppViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    private lateinit var favouritePatents: List<Patent>

    private lateinit var adapter: FavAdapter

    companion object {
        fun getNewInstance() = FavFragment()
    }

    override fun getXMLLayout(): Int {
        return R.layout.fragment_fav
    }

    override fun initValues() {
        mViewModel.getFavouritePatents().observe(this, Observer {
            activity?.let { appContext ->
                adapter = FavAdapter(it, appContext) {

                }
                recycler_view.adapter = adapter
                recycler_view.layoutManager = LinearLayoutManager(appContext)
                recycler_view.addItemDecoration(
                    DividerItemDecoration(
                        context,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        })
    }

    override fun initListeners() {
    }
}