package com.lucassimao.cabojosiasinforma.home.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.ui.Screens
import com.lucassimao.cabojosiasinforma.core.ui.checkFirstTimeAndShowDialog
import com.lucassimao.cabojosiasinforma.core.ui.showAlertDialog
import com.lucassimao.cabojosiasinforma.databinding.HomeFragmentBinding
import com.lucassimao.cabojosiasinforma.home.presentation.view_model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("DEPRECATION")
@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        checkFirstTimeAndShowDialog()

        goToNextScreen()
        setupHomeCardList()
    }

    private fun goToNextScreen() {
        val navigationActions = mapOf(
            Screens.BIOGRAPHY to R.id.action_homeFragment_to_biographyFragment,
            Screens.PROJECTS to R.id.action_homeFragment_to_projectsFragment,
            Screens.MEETING to R.id.action_homeFragment_to_meetingFragment
        )

        homeAdapter.onHomeCardClick = {
            navigationActions[it.type]?.let { actionId ->
                findNavController().navigate(actionId)
            }
        }
    }

    private fun setupHomeCardList() {
        homeAdapter.getHomeCardList(homeViewModel.fetchHomeCards())
        binding.rvHomeCard.adapter = homeAdapter
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                showAlertDialog(
                    getString(R.string.important_warning),
                    getString(R.string.warning)
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}