package com.example.nasaapp.scenes.main.list

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.R
import com.example.nasaapp.data.model.Patent
import kotlinx.android.synthetic.main.item_patent.view.*

class ListAdapter(private val context: Context, private val clickListener: (Patent) -> Unit): RecyclerView.Adapter<ListAdapter.PatentHolder>() {

    private var patents = mutableListOf<Patent>()

    fun setPatents(patents: List<Patent>) {
        this.patents.clear()
        this.patents.addAll(patents)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatentHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_patent, parent, false)
        return PatentHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: PatentHolder, position: Int) {
        Glide.with(context).load(patents[position].imageUrlString).into(holder.itemView.list_patent_image)
        holder.itemView.list_patent_name.text = patents[position].name
        holder.itemView.setOnClickListener {
            clickListener(patents[position])
        }
    }

    override fun getItemCount(): Int {
        return patents.size
    }

    inner class PatentHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}
}