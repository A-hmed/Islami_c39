package com.route.islami_c39.ui.screens.home.fragments.ahadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_c39.R
import com.route.islami_c39.ui.model.HadethModel

class AhadethAdapter(var ahadeth: List<HadethModel>) : RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_sura_name,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = ahadeth[position].title
        holder.hadethNameTv.text = title
        if (onHadethClick != null) {
            holder.itemView.setOnClickListener {
                onHadethClick!!.onItemClick(ahadeth[position], position)
            }
        }
    }

    override fun getItemCount(): Int = ahadeth.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadethNameTv: TextView = itemView.findViewById(R.id.itemSuraNameTv)
    }

    var onHadethClick: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(hadeth: HadethModel, index: Int)
    }
}
