package com.lucassimao.cabojosiasinforma.notification

import android.content.Context
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.lucassimao.cabojosiasinforma.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    fun provideMessagingService(): FirebaseMessagingService {
        return MessagingService()
    }

    @Provides
    fun provideNotificationBuilder(
        @ApplicationContext context: Context,
        channelId: String
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_notifications)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
    }

    @Provides
    fun provideChannelId(): String = "notification_channel"
}
