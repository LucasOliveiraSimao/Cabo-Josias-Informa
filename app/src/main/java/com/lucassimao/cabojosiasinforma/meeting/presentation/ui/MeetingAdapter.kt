package com.lucassimao.cabojosiasinforma.meeting.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.cabojosiasinforma.databinding.HomeItemListBinding
import com.lucassimao.cabojosiasinforma.databinding.MeetingItemListBinding
import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import javax.inject.Inject

class MeetingAdapter @Inject constructor() : RecyclerView.Adapter<MeetingAdapterViewHolder>() {

    private val list = mutableListOf<MeetingDataModel>()

    val getMeetingList: (List<MeetingDataModel>) -> Unit = {
        list.clear()
        list.addAll(it)
    }

    var onHomeCardClick: (MeetingDataModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingAdapterViewHolder {
        val binding = MeetingItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MeetingAdapterViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MeetingAdapterViewHolder, position: Int) {
        holder.bind(list[position], onHomeCardClick)
    }
}

class MeetingAdapterViewHolder(
    private val binding: MeetingItemListBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(meetingDataModel: MeetingDataModel, onHomeCardClick: (MeetingDataModel) -> Unit) {

        binding.meetingTitle.text = meetingDataModel.title
        binding.meetingDate.text = meetingDataModel.date
        binding.meetingLocation.text = meetingDataModel.location
        binding.meetingObjective.text = meetingDataModel.objective
        binding.meetingParticipants.text = meetingDataModel.participants
//        binding.root.setOnClickListener {
//            onHomeCardClick.invoke(homeDataModel)
//        }

    }
}
