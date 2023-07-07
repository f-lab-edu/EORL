package com.eorl.service.notification;

import com.eorl.domain.notification.Notification;
import com.eorl.domain.notification.NotificationStatus;
import com.eorl.repository.MemberRepository;
import com.eorl.repository.notification.NotificationRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public List<Notification> findAllOrderByNotificationId() {
        return null;
    }

    @Override
    public int updateNotificationStatus(UUID alarmId, NotificationStatus notificationStatus) {
        return 0;
    }
}
