package com.lucassimao.cabojosiasinforma.core.ui

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(
    view: View,
    context: Context,
    messageResId: Int,
    vararg formatArgs: Any,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionText: String? = null,
    actionListener: View.OnClickListener? = null
) {
    val message = context.getString(messageResId, *formatArgs)
    val snackbar = Snackbar.make(view, message, duration)
    if (actionText != null && actionListener != null) {
        snackbar.setAction(actionText, actionListener)
    }
    snackbar.show()
}