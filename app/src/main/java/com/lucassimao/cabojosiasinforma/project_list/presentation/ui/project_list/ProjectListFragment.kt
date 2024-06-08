package com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lucassimao.cabojosiasinforma.BaseFragment
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.ui.DiffCallbackUtil
import com.lucassimao.cabojosiasinforma.core.ui.GenericListAdapter
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.core.ui.bundleKey
import com.lucassimao.cabojosiasinforma.core.ui.dismissProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.showProgressDialog
import com.lucassimao.cabojosiasinforma.databinding.ProjectListFragmentBinding
import com.lucassimao.cabojosiasinforma.databinding.ProjectListItemListBinding
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.presentation.view_model.ProjectListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProjectListFragment : BaseFragment<ProjectListFragmentBinding>(
    ProjectListFragmentBinding::class
) {

    private val projectListViewModel: ProjectListViewModel by viewModels()

    private lateinit var projectListAdapter: GenericListAdapter<ProjectListDataModel, ProjectListItemListBinding>

    private var projectList = listOf<ProjectListDataModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupProjectList()
    }

    private fun setupProjectList() {

        projectListAdapter = GenericListAdapter(
            bindingInflater = { inflater, parent, attachToParent ->
                ProjectListItemListBinding.inflate(inflater, parent, attachToParent)
            },
            onBind = { item ->
                projectListTitle.text = item.title
            },
            diffCallback = DiffCallbackUtil()
        )
        goToNextScreen()
        fetchProjectList()
        observerUiState()
    }

    private fun goToNextScreen() {
        projectListAdapter.onItemClick = { project ->
            val bundle = bundleOf(bundleKey to project.id)
            findNavController().navigate(
                R.id.action_projectsFragment_to_projectDetailsFragment,
                bundle
            )
        }
    }

    private fun fetchProjectList() {
        projectListViewModel.fetchProjectList()
    }

    override fun observerUiState() {
        lifecycleScope.launch {
            projectListViewModel.uiState.collect { uiState ->
                handleUiState(uiState)
            }
        }
    }

    private fun handleUiState(uiState: UiState<List<ProjectListDataModel>>) {
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


    private fun handleSuccessState(successState: UiState.Success<List<ProjectListDataModel>>) {
        projectList = successState.data
        projectListAdapter.submitList(projectList)
        binding.rvProjectsList.adapter = projectListAdapter
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), "Erro ao carregar projetos: $message", Toast.LENGTH_SHORT)
            .show()
    }

}