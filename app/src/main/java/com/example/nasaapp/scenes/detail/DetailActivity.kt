package com.example.nasaapp.scenes.detail

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nasaapp.R
import com.example.nasaapp.base.BaseTemplate
import com.example.nasaapp.common.AppViewModelFactory
import com.example.nasaapp.data.model.Patent
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseTemplate.BaseActivity() {

    private val mViewModel: DetailViewModel by lazy {
        val factory = AppViewModelFactory(application)
        ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    private var favApod = false

    private lateinit var patent: Patent

    override fun getXMLLayout(): Int {
        return R.layout.activity_detail
    }

    override fun initValues(savedInstanceState: Bundle?) {
        title = "Patent detail"
        if (savedInstanceState == null) {
            deserializePatent()
        }

        setValueToUI()
    }

    private fun setValueToUI() {
        Glide.with(this@DetailActivity)
            .load(patent.imageUrlString)
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_foreground_back))
            .into(card_view_detail_image)
        card_view_detail_name.text = patent.name
        card_view_detail_desc.text = patent.description
    }

    private fun deserializePatent() {

        if (intent.getStringExtra("PATENT_STATUS") == "not_fav_patent") {
            patent = intent.getSerializableExtra("PATENT_REMOTE") as Patent
            detail_boton.setImageResource(R.drawable.ic_star)
        } else {
            patent = intent.getSerializableExtra("PATENT_LOCAL") as Patent
            detail_boton.setImageResource(R.drawable.ic_delete)
            favApod = true
        }

    }

    override fun initListeners() {
        detail_boton.setOnClickListener {
            if(favApod) {
                mViewModel.deletePatent(patent)
            } else {
                mViewModel.savePatent(patent)
            }

            finish()
        }
    }
}