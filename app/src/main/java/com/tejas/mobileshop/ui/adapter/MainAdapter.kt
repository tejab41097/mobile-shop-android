package com.tejas.mobileshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tejas.mobileshop.databinding.ItemMobileBinding
import com.tejas.mobileshop.model.Option

class MainAdapter : RecyclerView.Adapter<MobileViewHolder>() {
    private var data: MutableList<Option> = mutableListOf()
    lateinit var itemClickListener: ItemClickListener
    fun submitList(albums: MutableList<Option>) {
        data = albums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MobileViewHolder(
        ItemMobileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MobileViewHolder, position: Int) {
        Glide.with(holder.view.root.context)
            .load(data[position].icon)
            .into(holder.view.ivIcon)
        holder.view.tvTitle.text = data[position].name
            .replace("e", "")
            .replace("E", "")
        holder.view.root.setOnClickListener {
            itemClickListener.click(data[position])
        }
    }

    interface ItemClickListener {
        fun click(model: Option)
    }
}

class MobileViewHolder(val view: ItemMobileBinding) : RecyclerView.ViewHolder(view.root)

