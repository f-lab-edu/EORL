package com.eorl.repository.notification;

import com.eorl.domain.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationRepositoryCustom {
    Page<Notification> findAll(Notification notification, Pageable pageable);
}
