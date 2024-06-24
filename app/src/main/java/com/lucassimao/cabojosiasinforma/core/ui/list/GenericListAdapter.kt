package com.lucassimao.cabojosiasinforma.core.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class GenericListAdapter<T, VB : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> VB,
    private val onBind: VB.(T) -> Unit,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, GenericListAdapter.GenericViewHolder<VB>>(diffCallback) {

    var onItemClick: ((T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = bindingInflater(inflater, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<VB>, position: Int) {
        val item = getItem(position)
        holder.binding.onBind(item)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    class GenericViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}