package com.lucassimao.cabojosiasinforma.biography.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lucassimao.cabojosiasinforma.BaseFragment
import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.presentation.view_model.BiographyViewModel
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.core.ui.dismissProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.showProgressDialog
import com.lucassimao.cabojosiasinforma.core.ui.showToast
import com.lucassimao.cabojosiasinforma.databinding.BiographyFragmentBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BiographyFragment : BaseFragment<BiographyFragmentBinding>(
    BiographyFragmentBinding::class
) {

    private val biographyViewModel: BiographyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchBiography()
        observerUiState()
    }

    private fun fetchBiography() {
        biographyViewModel.fetchBiography()
    }

    override fun observerUiState() {
        lifecycleScope.launch {
            biographyViewModel.uiState.collect { uiState ->
                handleUiState(uiState)
            }
        }
    }

    private fun handleUiState(uiState: UiState<BiographyDataModel>) {
        when (uiState) {
            is UiState.Error -> {
                dismissProgressDialog()
                showErrorMessage(uiState.throwable.message!!)
            }

            UiState.Loading -> {
                showProgressDialog()
            }

            is UiState.Success -> {
                showProgressDialog()
                handleSuccessState(uiState)
            }
        }
    }

    private fun handleSuccessState(uiState: UiState.Success<BiographyDataModel>) {
        val biography = uiState.data
        loadImage(
            biography.urlImg,
            { onImageLoadSuccess(biography.description) },
            ::onImageLoadError
        )
    }

    private fun loadImage(url: String, onSuccess: () -> Unit, onError: (Exception?) -> Unit) {
        Picasso.get().load(url).into(binding.biographyImage, object : Callback {
            override fun onSuccess() {
                onSuccess()
            }

            override fun onError(e: Exception?) {
                onError(e)
            }
        })
    }

    private fun onImageLoadSuccess(description: String) {
        dismissProgressDialog()
        binding.biographyDescription.text = description
    }

    private fun onImageLoadError(e: Exception?) {
        showErrorMessage(e?.message ?: "Unknown error")
    }

    override fun showErrorMessage(message: String) {
        showToast(requireContext(), "Erro ao carregar biografia: $message")
    }

}