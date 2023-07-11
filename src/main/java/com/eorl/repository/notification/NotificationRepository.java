package com.eorl.repository.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NotificationRepository extends JpaRepository<Notification, UUID>,
        NotificationRepositoryCustom {

    Notification findByNotificationId(UUID notificationId);

    Page<Notification> findAllByOrderByRegistrationDatetime(Pageable pageable);


    @Query("UPDATE Notification "
            + "SET notificationStatus = :notificationStatus "
            + "WHERE notificationId = :notificationId")
    @Modifying(clearAutomatically = true)
    @Transactional
    int updateNotificationStatus(@Param("notificationStatus") NotificationStatus notificationStatus, @Param("notificationId") UUID notificationId);

}
