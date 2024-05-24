package com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.databinding.ProjectListFragmentBinding
import com.lucassimao.cabojosiasinforma.project.presentation.view_model.ProjectListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProjectListFragment : Fragment() {
    private lateinit var binding: ProjectListFragmentBinding

    private val projectListViewModel: ProjectListViewModel by viewModels()

    @Inject
    lateinit var projectListAdapter: ProjectListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToNextScreen()
        setupProjectList()
    }

    private fun goToNextScreen() {
        projectListAdapter.onProjectListClick = {
            val bundle = bundleOf("project" to it.id)
            findNavController().navigate(
                R.id.action_projectsFragment_to_projectDetailsFragment,
                bundle
            )
        }
    }

    private fun setupProjectList() {
        projectListAdapter.getProjectList(projectListViewModel.fetchProjectList())
        binding.rvProjectsList.adapter = projectListAdapter
    }

}