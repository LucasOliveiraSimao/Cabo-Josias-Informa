@file:Suppress("DEPRECATION")

package com.lucassimao.cabojosiasinforma.core.ui

import android.app.ProgressDialog
import androidx.fragment.app.Fragment

var progressDialog: ProgressDialog? = null
fun Fragment.showProgressDialog() {
    if (progressDialog == null) {
        progressDialog = ProgressDialog(context)
        progressDialog?.setMessage("Carregando...")
        progressDialog?.setCancelable(false)
    }
    progressDialog?.show()
}

fun dismissProgressDialog() {
    progressDialog?.dismiss()
}