package com.lucassimao.cabojosiasinforma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<VB : ViewBinding, T>(private val bindingClass: KClass<VB>) :
    Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingClass.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
            .invoke(null, inflater, container, false) as VB
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun observerUiState()
    abstract fun handleUiState(uiState: UiState<T>)
    abstract fun handleSuccessState(successState: UiState.Success<T>)
    abstract fun showErrorMessage(message: String)
}