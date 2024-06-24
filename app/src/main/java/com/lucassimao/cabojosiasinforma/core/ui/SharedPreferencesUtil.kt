package com.lucassimao.cabojosiasinforma.core.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.lucassimao.cabojosiasinforma.R

private const val PREFS_NAME = "my_preferences"
private const val PREF_FIRST_TIME = "first_time"

fun Fragment.checkFirstTimeAndShowDialog() {
    if (isFirstTime()) {
        showAlertDialog(
            getString(R.string.important_warning),
            getString(R.string.membership_notice)
        )
        setFirstTimeFlag()
    }
}

private fun Fragment.isFirstTime(): Boolean {
    val settings = getPreferences()
    return settings.getBoolean(PREF_FIRST_TIME, true)
}

private fun Fragment.setFirstTimeFlag() {
    val settings = getPreferences()
    val editor = settings.edit()
    editor.putBoolean(PREF_FIRST_TIME, false)
    editor.apply()
}

private fun Fragment.getPreferences(): SharedPreferences {
    return requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}