package com.eorl.service.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import java.util.List;
import java.util.UUID;

public interface NotificationService {

    Notification registerNotification(Notification notification);

    Notification findByNotificationId(UUID notificationId);

    List<Notification> findAllOrderByNotificationId();

    int updateNotificationStatus(UUID notificationId, NotificationStatus notificationStatus);

}
