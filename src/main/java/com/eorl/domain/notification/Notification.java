package com.eorl.domain.notification;

import com.eorl.domain.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "notification")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID notificationId;

    @Column(nullable = false)
    private Long sendMemberId;

    @Column(nullable = false)
    private Long receiveMemberId;

    @Column(columnDefinition = "TEXT")
    private String notificationMsg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationKind notificationKind;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus notificationStatus;

    public Notification(Long sendMemberId, Long receiveMemberId, String notificationMsg, NotificationKind notificationKind,
            NotificationStatus notificationStatus) {
        this.sendMemberId = sendMemberId;
        this.receiveMemberId = receiveMemberId;
        this.notificationMsg = notificationMsg;
        this.notificationKind = notificationKind;
        this.notificationStatus = notificationStatus;
    }
}
