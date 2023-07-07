package com.eorl.controller.notification;

import com.eorl.domain.common.validator.EnumValue;
import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationSaveForm;
import com.eorl.domain.notification.NotificationStatus;
import com.eorl.service.notification.NotificationService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/notification")
@RequiredArgsConstructor
@Validated
public class NotificationController {

    private final NotificationService notificationService;


    /**
     * 알림등록
     *
     * @param notificationSaveForm
     * @return
     */
    @PostMapping
    public Notification saveNotification(
            @RequestBody @Valid NotificationSaveForm notificationSaveForm) {
        Notification notification = new Notification(notificationSaveForm.getSendMemberId(),
                notificationSaveForm.getReceiveMemberId(),
                notificationSaveForm.getNotificationMsg(),
                notificationSaveForm.getNotificationKind(),
                notificationSaveForm.getNotificationStatus());
        return notificationService.registerNotification(notification);
    }

    //아이디로 알림내역 확인
    @GetMapping("/{notificationId}")
    public Notification requestNotificationById(@PathVariable UUID notificationId) {
        return notificationService.findByNotificationId(notificationId);
    }
    //모든 알람 조회
    @GetMapping
    public Page<Notification> findAllOrderByNotificationId(Pageable pageable) {
        return notificationService.findAllOrderByNotificationId(pageable);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PatchMapping("/updateNotificationStatus")
    public void updateNotificationStatus(@RequestParam UUID notificationId,
            @RequestParam @EnumValue(enumClass = NotificationStatus.class, message = "유효하지 않은 알람상태입니다.")
            String notificationStatus){
        notificationService.updateNotificationStatus(notificationId, NotificationStatus.valueOf(notificationStatus));
    }


}
