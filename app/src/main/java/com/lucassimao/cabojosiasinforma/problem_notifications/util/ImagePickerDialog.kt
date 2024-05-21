package com.lucassimao.cabojosiasinforma.problem_notifications.util

import android.app.AlertDialog
import android.content.Context
import com.lucassimao.cabojosiasinforma.R

class ImagePickerDialog(
    private val context: Context,
    private val onCameraSelected: () -> Unit,
    private val onGallerySelected: () -> Unit
) {
    fun show() {
        val options = arrayOf(
            context.getString(R.string.camera_option),
            context.getString(R.string.gallery_option)
        )
        AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.choose_image))
            .setItems(options) { _, which ->
                when (which) {
                    0 -> onCameraSelected()
                    1 -> onGallerySelected()
                }
            }
            .create()
            .show()
    }
}