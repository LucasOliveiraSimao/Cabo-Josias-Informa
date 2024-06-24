package com.lucassimao.cabojosiasinforma.core.ui.share

import android.content.Intent
import androidx.fragment.app.Fragment

fun Fragment.shareInfo(shareBy: String, item: Shareable) {
    val shareIntent = createShareIntent(item.getShareableContent())
    val chooserIntent = Intent.createChooser(shareIntent, shareBy)
    startActivity(chooserIntent)
}

private fun createShareIntent(content: String): Intent {
    return Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, content)
    }
}