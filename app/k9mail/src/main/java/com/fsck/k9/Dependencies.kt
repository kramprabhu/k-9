package com.fsck.k9

import com.fsck.k9.backends.backendsModule
import com.fsck.k9.external.BroadcastSenderListener
import com.fsck.k9.external.externalModule
import com.fsck.k9.notification.notificationModule
import com.fsck.k9.resources.resourcesModule
import com.fsck.k9.widget.list.MessageListWidgetUpdateListener
import com.fsck.k9.widget.list.messageListWidgetModule
import com.fsck.k9.widget.unread.UnreadWidgetUpdateListener
import com.fsck.k9.widget.unread.unreadWidgetModule
import org.koin.dsl.module.applicationContext

private val mainAppModule = applicationContext {
    bean { App.appConfig }
    bean { MessagingListenerProvider(
            listOf(
                    get<UnreadWidgetUpdateListener>(),
                    get<MessageListWidgetUpdateListener>(),
                    get<BroadcastSenderListener>()
            ))
    }
}

val appModules = listOf(
        mainAppModule,
        externalModule,
        messageListWidgetModule,
        unreadWidgetModule,
        notificationModule,
        resourcesModule,
        backendsModule
)
