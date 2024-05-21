package com.lucassimao.cabojosiasinforma.home.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.cabojosiasinforma.databinding.HomeItemListBinding
import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import javax.inject.Inject

class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapterViewHolder>() {

    private val list = mutableListOf<HomeDataModel>()

    val getHomeCardList: (List<HomeDataModel>) -> Unit = {
        list.clear()
        list.addAll(it)
    }

    var onHomeCardClick: (HomeDataModel) -> Unit = {}

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

    fun bind(homeDataModel: HomeDataModel, onHomeCardClick: (HomeDataModel) -> Unit) {

        binding.avatar.setImageResource(homeDataModel.icon)
        binding.title.text = homeDataModel.title
        binding.root.setOnClickListener {
            onHomeCardClick.invoke(homeDataModel)
        }

    }
}
