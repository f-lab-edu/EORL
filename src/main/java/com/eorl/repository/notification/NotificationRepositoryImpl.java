package com.eorl.repository.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import com.eorl.domain.notification.QNotification;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    QNotification qnotification = QNotification.notification;

    @Override
    public Page<Notification> findAll(Notification notification, Pageable pageable) {
        //return null;

        List<Notification> notificationList = queryFactory
                .selectFrom(qnotification)
                .where(eqNotificationStatus(notification.getNotificationStatus())).fetch();

        return new PageImpl<>(notificationList);
    }

    private BooleanExpression eqNotificationStatus(NotificationStatus notificationStatus) {
        return notificationStatus == null ? null : qnotification.notificationStatus.eq(notificationStatus);
    }
}
