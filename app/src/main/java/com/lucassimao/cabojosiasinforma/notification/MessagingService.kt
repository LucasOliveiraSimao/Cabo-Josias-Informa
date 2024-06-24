package com.lucassimao.cabojosiasinforma.notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MessagingService @Inject constructor(): FirebaseMessagingService() {
    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        remoteMessage.notification?.let {
            notificationHelper.showNotification(
                it.title ?: "No Title",
                it.body ?: "No Message"
            )
        }
    }
}