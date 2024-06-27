package com.lucassimao.cabojosiasinforma.core.ui

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import com.lucassimao.cabojosiasinforma.R

private var customProgressDialog: AlertDialog? = null

fun Fragment.showProgressDialog() {
    if (context == null || !isAdded || isRemoving) {
        return
    }

    if (customProgressDialog == null) {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_progress_dialog, null)
        builder.setView(dialogView)
        builder.setCancelable(true)

        customProgressDialog = builder.create()
    }

    if (customProgressDialog?.isShowing == false) {
        customProgressDialog?.show()
    }
}

fun dismissProgressDialog() {
    customProgressDialog?.dismiss()
    customProgressDialog = null
}
