package com.eorl.domain.notification;

import com.eorl.domain.common.validator.EnumValue;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSaveForm {

    @NotEmpty(message="sendMemberId은 필수 입니다.")
    private Long sendMemberId;

    @NotEmpty(message="receiveMemberId은 필수 입니다.")
    private Long receiveMemberId;

    private String notificationMsg;

    @EnumValue(enumClass = NotificationKind.class, message = "유효하지 않은 알람종류입니다.")
    private String notificationKind;

    public NotificationKind getNotificationKind() {
        return NotificationKind.valueOf(notificationKind);
    }

    @EnumValue(enumClass = NotificationStatus.class, message = "유효하지 않은 알람상태입니다.")
    private String notificationStatus;

    public NotificationStatus getNotificationStatus() {
        return NotificationStatus.valueOf(notificationStatus);
    }

}
