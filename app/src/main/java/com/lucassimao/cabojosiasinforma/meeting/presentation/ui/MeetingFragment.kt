package com.lucassimao.cabojosiasinforma.meeting.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lucassimao.cabojosiasinforma.BaseFragment
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.core.ui.dismissProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.list.DiffCallbackUtil
import com.lucassimao.cabojosiasinforma.core.ui.list.GenericListAdapter
import com.lucassimao.cabojosiasinforma.core.ui.share.shareInfo
import com.lucassimao.cabojosiasinforma.core.ui.showProgressDialog
import com.lucassimao.cabojosiasinforma.databinding.MeetingFragmentBinding
import com.lucassimao.cabojosiasinforma.databinding.MeetingListItemBinding
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.presentation.view_model.MeetingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MeetingFragment : BaseFragment<MeetingFragmentBinding, List<MeetingDataModel>>(
    MeetingFragmentBinding::class
) {

    private val meetingViewModel: MeetingViewModel by viewModels()

    private lateinit var meetingAdapter: GenericListAdapter<MeetingDataModel, MeetingListItemBinding>

    private var meetingList = listOf<MeetingDataModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMeetingList()
    }

    private fun setupMeetingList() {
        meetingAdapter = GenericListAdapter(
            bindingInflater = { inflater, parent, attachToParent ->
                MeetingListItemBinding.inflate(inflater, parent, attachToParent)
            },
            onBind = { item ->
                meetingTitle.text = item.title
                meetingDate.text = item.date
                meetingLocation.text = item.location
                meetingObjective.text = item.objective
                meetingParticipants.text = item.participants
                meetingShare.setOnClickListener {
                    shareInfo(
                        getString(R.string.share_via),
                        item
                    )
                }
            },
            diffCallback = DiffCallbackUtil()
        )

        fetchMeetingList()
        observerUiState()
    }

    private fun fetchMeetingList() {
        meetingViewModel.fetchMeetings()
    }

    override fun observerUiState() {
        lifecycleScope.launch {
            meetingViewModel.uiState.collect { uiState ->
                handleUiState(uiState)
            }
        }
    }

    override fun handleUiState(uiState: UiState<List<MeetingDataModel>>) {
        when (uiState) {
            is UiState.Error -> {
                dismissProgressDialog()
                showErrorMessage(uiState.throwable.message!!)
            }

            UiState.Loading -> {
                showProgressDialog()
            }

            is UiState.Success -> {
                dismissProgressDialog()
                handleSuccessState(uiState)
            }
        }
    }

    override fun handleSuccessState(successState: UiState.Success<List<MeetingDataModel>>) {
        meetingList = successState.data
        meetingAdapter.submitList(meetingList)
        binding.rvMeetingList.adapter = meetingAdapter
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), "Erro ao carregar encontros: $message", Toast.LENGTH_SHORT)
            .show()
    }
}