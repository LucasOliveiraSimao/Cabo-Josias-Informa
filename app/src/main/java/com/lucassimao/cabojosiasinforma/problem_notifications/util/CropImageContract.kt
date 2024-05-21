package com.lucassimao.cabojosiasinforma.problem_notifications.util

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.theartofdev.edmodo.cropper.CropImage

class CropImageContract : ActivityResultContract<Any?, CropImage.ActivityResult>() {
    override fun createIntent(context: Context, input: Any?): Intent {
        return CropImage.activity().getIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CropImage.ActivityResult {
        return CropImage.getActivityResult(intent)
    }
}