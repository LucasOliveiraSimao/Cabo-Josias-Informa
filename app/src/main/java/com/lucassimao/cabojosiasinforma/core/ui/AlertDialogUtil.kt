package com.lucassimao.cabojosiasinforma.core.ui

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment
import com.lucassimao.cabojosiasinforma.R

fun Fragment.showAlertDialog(title: String, message: String) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(getString(R.string.ok)) { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }
        .setCancelable(false)
        .create().show()
}