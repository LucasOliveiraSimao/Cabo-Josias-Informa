package com.lucassimao.cabojosiasinforma.core.ui

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}