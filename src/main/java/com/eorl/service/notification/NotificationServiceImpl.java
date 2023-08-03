package com.eorl.service.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import com.eorl.repository.member.MemberRepository;
import com.eorl.repository.notification.NotificationRepository;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final MemberRepository memberRepository;

    @Override
    public Notification registerNotification(Notification notification) {
        if (memberRepository.findByMemberId(notification.getSendMemberId()) == null) {
            throw new NoSuchElementException("아이디가 '" + notification.getSendMemberId() + "' 멤버는 존재하지 않습니다.");
        }
        if (memberRepository.findByMemberId(notification.getReceiveMemberId()) == null) {
            throw new NoSuchElementException("아이디가 '" + notification.getReceiveMemberId() + "' 멤버는 존재하지 않습니다.");
        }
        return notificationRepository.save(notification);
    }

    @Override
    public Notification findByNotificationId(UUID alarmId) {
        return notificationRepository.findByNotificationId(alarmId);
    }

    @Override
    public Page<Notification> findAllOrderByNotificationId(Pageable pageable) {
        return notificationRepository.findAllByOrderByRegistrationDatetime(pageable);
    }

    @Override
    public int updateNotificationStatus(UUID notificationId, NotificationStatus notificationStatus) {
        if (notificationRepository.findByNotificationId(notificationId) == null) {
            throw new NoSuchElementException("'" + notificationId + "' 라는 알림은 존재하지 않습니다.");
        }
        int result =  notificationRepository.updateNotificationStatus(notificationStatus,notificationId);
        if (result != 1) {
            throw new RuntimeException("업데이트 중 오류가 발생하였습니다.");
        }
        return result;
    }
}
