package com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lucassimao.cabojosiasinforma.databinding.ProjectDetailsFragmentBinding
import com.lucassimao.cabojosiasinforma.project_list.presentation.view_model.ProjectDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectDetailsFragment : Fragment() {
    private lateinit var binding: ProjectDetailsFragmentBinding

    private val projectDetailsViewModel: ProjectDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val project = arguments?.getInt("project")?.let { id ->
            projectDetailsViewModel.getProjectDetails(id)
        }

        project?.let {
            binding.projectDetailsTitle.text = it.title
            binding.projectDetailsDescription.text = it.description
        }

    }
}