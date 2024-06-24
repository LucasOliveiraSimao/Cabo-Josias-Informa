package com.lucassimao.cabojosiasinforma.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.lucassimao.cabojosiasinforma.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationHelper @Inject constructor(
    @ApplicationContext private val context: Context,
    private val builder: NotificationCompat.Builder,
    private val channelId: String
) {
    fun showNotification(title: String, message: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            action = ACTION_NOTIFICATION
        }

        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val notificationBuilder = builder
            .setContentIntent(pendingIntent)
            .setContentTitle(title)
            .setContentText(message)

        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId, "web_app",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    companion object {
        const val ACTION_NOTIFICATION = "actionNotification"
    }
}
