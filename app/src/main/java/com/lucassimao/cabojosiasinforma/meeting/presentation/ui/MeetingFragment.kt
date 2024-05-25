package com.lucassimao.cabojosiasinforma.meeting.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lucassimao.cabojosiasinforma.databinding.MeetingFragmentBinding
import com.lucassimao.cabojosiasinforma.meeting.presentation.view_model.MeetingViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MeetingFragment : Fragment() {
    private lateinit var binding: MeetingFragmentBinding

    private val meetingViewModel: MeetingViewModel by viewModels()

    @Inject
    lateinit var meetingAdapter: MeetingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MeetingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMeetingList()
    }

    private fun setupMeetingList() {
        meetingAdapter.getMeetingList(meetingViewModel.fetchMeetings())
        binding.rvMeetingList.adapter = meetingAdapter
    }
}