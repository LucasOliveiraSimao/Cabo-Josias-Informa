package com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lucassimao.cabojosiasinforma.BaseFragment
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.core.ui.bundleKey
import com.lucassimao.cabojosiasinforma.core.ui.dismissProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.share.shareInfo
import com.lucassimao.cabojosiasinforma.core.ui.showProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.showSnackbar
import com.lucassimao.cabojosiasinforma.databinding.ProjectDetailsFragmentBinding
import com.lucassimao.cabojosiasinforma.project_list.data.model.ActionDataModel
import com.lucassimao.cabojosiasinforma.project_list.presentation.model.ProjectUiModel
import com.lucassimao.cabojosiasinforma.project_list.presentation.view_model.ProjectDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProjectDetailsFragment : BaseFragment<ProjectDetailsFragmentBinding>(
    ProjectDetailsFragmentBinding::class
) {

    private val projectDetailsViewModel: ProjectDetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerUiState()
    }

    override fun observerUiState() {
        getProjectDetails()
        lifecycleScope.launch {
            projectDetailsViewModel.uiState.collect { uiState ->
                handleUiState(uiState)
            }
        }
    }

    private fun getProjectDetails() {
        arguments?.getInt(bundleKey)?.let { id ->
            projectDetailsViewModel.getProjectDetails(id)
        }
    }

    private fun handleUiState(uiState: UiState<ProjectUiModel>) {
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

    private fun handleSuccessState(uiState: UiState.Success<ProjectUiModel>) {

        binding.projectDetailsTitle.text = uiState.data.title
        binding.projectDetailsDescription.text = uiState.data.description

        val objectivesString = buildObjectivesString(uiState.data.objectives)
        val actionsString = buildActionsString(uiState.data.actions)

        setText(binding.projectDetailsObjectives, R.string.objectives_format, objectivesString)
        setText(binding.projectDetailsActions, R.string.actions_format, actionsString)

        binding.projectShare.setOnClickListener {
            shareInfo(getString(R.string.share_via), uiState.data)
        }
    }

    private fun setText(view: TextView?, prefixResId: Int, content: String) {
        val formattedText = getString(prefixResId, content)
        view?.text = formattedText
    }

    private fun buildActionsString(actionDataModels: List<ActionDataModel>): String {
        return actionDataModels.joinToString(separator = "\n\n") { "${it.title}:\n${it.description}" }
    }

    private fun buildObjectivesString(objectives: List<String>): String {
        return objectives.joinToString(separator = "\n") { it }
    }


    override fun showErrorMessage(message: String) {
        showSnackbar(
            view = requireView(),
            context = requireContext(),
            messageResId = R.string.error_loading_project,
            message
        )
    }
}