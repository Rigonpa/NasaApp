package com.example.nasaapp.scenes.main.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import com.example.nasaapp.common.AppViewModelFactory
import com.example.nasaapp.data.model.Patent
import com.example.nasaapp.scenes.detail.DetailActivity
import com.example.nasaapp.scenes.main.MainViewModel
import com.google.android.material.snackbar.Snackbar
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : BaseTemplate.BaseFragment() {

    private lateinit var adapter: ListAdapter

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
            recycler_view.loadSkeleton(R.layout.item_patent)
            mViewModel.getPatentsAbout(search_text.text.toString()).observe(this, Observer {
                if (it != null && it.isNotEmpty()) {
                    loadRecyclerView(it)
                } else {
                    recycler_view.hideSkeleton()
                    Snackbar.make(
                        main_fragment_container,
                        "There are no patents for that object.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            })
        }
    }

    private fun loadRecyclerView(it: List<Patent>) {
        activity?.let { appContext ->
            adapter = ListAdapter(appContext) {
                goToDetailActivity(appContext, it)
            }
            recycler_view.hideSkeleton()
            adapter.setPatents(it)
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(appContext)
        }
    }

    private fun goToDetailActivity(
        appContext: FragmentActivity,
        patent: Patent
    ) {
        Intent(appContext, DetailActivity::class.java).apply {

            arguments = Bundle().apply {
                this.putSerializable("PATENT_REMOTE", patent)
            }

            arguments?.let {
                putExtras(it)
            }

            putExtra("PATENT_STATUS", "not_fav_patent")
            startActivity(this)
        }
    }
}