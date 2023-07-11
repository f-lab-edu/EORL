package com.eorl.service.notification;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationSaveForm;
import com.eorl.domain.notification.NotificationStatus;
import com.eorl.service.member.MemberService;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class NotificationServiceImplTest {

    @Autowired
    NotificationService notificationService;
    @Autowired
    MemberService memberService;

    Member member;

    @BeforeEach
    void before() {
        MemberSaveForm memberSaveForm = new MemberSaveForm("CLIENT", "배유연", "1234",
                "01085554444",
                "ddd@maver.com");
        member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        //when
        memberService.joinMember(member);

    }

    @Test
    @DisplayName("알람등록 테스트")
    void registerAlarm() {
        //given
        NotificationSaveForm notificationSaveForm = new NotificationSaveForm(member.getMemberId(),
                member.getMemberId()
                , "알람메시지 테스트", "NAVER", "PENDING");
        Notification notification = new Notification(notificationSaveForm.getSendMemberId(),
                notificationSaveForm.getReceiveMemberId()
                , notificationSaveForm.getNotificationMsg(),
                notificationSaveForm.getNotificationKind()
                , notificationSaveForm.getNotificationStatus());
        //when
        notificationService.registerNotification(notification);

        //then
        Notification findNotification = notificationService.findByNotificationId(
                notification.getNotificationId());
        assertThat(notification.getNotificationId()).isEqualTo(
                findNotification.getNotificationId());
    }

    @Test
    @DisplayName("존재하지 않는 멤버가 알람등록하기")
    void registerNoneUserAlarm() {
        //given
        NotificationSaveForm notificationSaveForm = new NotificationSaveForm(99999999L,
                member.getMemberId()
                , "알람메시지 테스트", "NAVER", "PENDING");
        Notification notification = new Notification(notificationSaveForm.getSendMemberId(),
                notificationSaveForm.getReceiveMemberId()
                , notificationSaveForm.getNotificationMsg(),
                notificationSaveForm.getNotificationKind()
                , notificationSaveForm.getNotificationStatus());

        //when
        //then
        assertThrows(NoSuchElementException.class,
                () -> notificationService.registerNotification(notification));
    }

    @Test
    @DisplayName("paging 처리 테스트")
    void findAllOrderByNotificationId() {
        //given
        for (int i = 0; i < 3; i++) {
            NotificationSaveForm notificationSaveForm = new NotificationSaveForm(
                    member.getMemberId(), member.getMemberId()
                    , "알람메시지 테스트", "NAVER", "PENDING");
            Notification notification = new Notification(notificationSaveForm.getSendMemberId(),
                    notificationSaveForm.getReceiveMemberId()
                    , notificationSaveForm.getNotificationMsg(),
                    notificationSaveForm.getNotificationKind()
                    , notificationSaveForm.getNotificationStatus());
            notificationService.registerNotification(notification);
        }
        PageRequest pageable = PageRequest.of(0, 10);
        //when
        Page<Notification> allOrderByNotificationId = notificationService.findAllOrderByNotificationId(
                pageable);

        assertThat(allOrderByNotificationId.getTotalElements()).isEqualTo(3);
    }

    @Test
    @DisplayName("상태 전송완료로 업데이트하기.")
    void updateNotificationStatus() {
        //given
        NotificationSaveForm notificationSaveForm = new NotificationSaveForm(member.getMemberId(),
                member.getMemberId()
                , "알람메시지 테스트", "NAVER", "PENDING");
        Notification notification = new Notification(notificationSaveForm.getSendMemberId(),
                notificationSaveForm.getReceiveMemberId()
                , notificationSaveForm.getNotificationMsg(),
                notificationSaveForm.getNotificationKind()
                , notificationSaveForm.getNotificationStatus());
        notificationService.registerNotification(notification);
        //when
        notificationService.updateNotificationStatus(notification.getNotificationId(),
                NotificationStatus.COMPLETE);
        //then
        Notification findNotification = notificationService.findByNotificationId(
                notification.getNotificationId());
        assertThat(findNotification.getNotificationStatus()).isEqualTo(NotificationStatus.COMPLETE);
    }

}