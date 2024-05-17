package com.lucassimao.cabojosiasinforma.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.cabojosiasinforma.databinding.HomeItemListBinding
import com.lucassimao.cabojosiasinforma.home.data.source.HomeCardModel
import javax.inject.Inject

class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapterViewHolder>() {

    private val list = mutableListOf<HomeCardModel>()

    val getHomeCardList: (List<HomeCardModel>) -> Unit = {
        list.clear()
        list.addAll(it)
    }

    var onHomeCardClick: (HomeCardModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val binding = HomeItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeAdapterViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.bind(list[position], onHomeCardClick)
    }
}

class HomeAdapterViewHolder(
    private val binding: HomeItemListBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(homeCardModel: HomeCardModel, onHomeCardClick: (HomeCardModel) -> Unit) {

        binding.avatar.setImageResource(homeCardModel.icon)
        binding.title.text = homeCardModel.title
        binding.root.setOnClickListener {
            onHomeCardClick.invoke(homeCardModel)
        }

    }
}
