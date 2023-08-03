package com.eorl.service.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {

    Notification registerNotification(Notification notification);

    Notification findByNotificationId(UUID notificationId);

    Page<Notification> findAllOrderByNotificationId(Pageable pageable);

    int updateNotificationStatus(UUID notificationId, NotificationStatus notificationStatus);

}
