@file:Suppress("DEPRECATION")

package com.lucassimao.cabojosiasinforma.core.ui

import android.app.ProgressDialog
import androidx.fragment.app.Fragment

var progressDialog: ProgressDialog? = null
fun Fragment.showProgressDialog() {
    if (context == null || !isAdded || isRemoving) {
        return
    }

    if (progressDialog == null) {
        progressDialog = ProgressDialog(requireContext()).apply {
            setMessage("Carregando...")
            setCancelable(true)
        }
    }
    if (progressDialog?.isShowing == false) {
        progressDialog?.show()
    }
}

fun dismissProgressDialog() {
    progressDialog?.dismiss()
    progressDialog = null
}