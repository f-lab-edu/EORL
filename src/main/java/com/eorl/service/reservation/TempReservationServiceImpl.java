package com.eorl.service.reservation;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.reservation.temp.TempReservation;
import com.eorl.domain.reservation.temp.TempReservationSaveForm;
import com.eorl.repository.MemberRepository;
import com.eorl.repository.TempReservationRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TempReservationServiceImpl implements TempReservationService{
    private final MemberRepository memberRepository;
    private final TempReservationRepository tempReservationRepository;

    @Override
    public TempReservation applyReservation(TempReservation tempReservation) {
        //지후님 개발 끝나면 가게 ID 체크로직 추가
        //해당 멤버 존재하는지 체크
        Member member = memberRepository.findByMemberId(tempReservation.getMemberId());
        if (member == null) {
            throw new NoSuchElementException("아이디가 '" + tempReservation.getMemberId() + "' 멤버는 존재하지 않습니다.");
        }
        tempReservationRepository.save(tempReservation);
        return tempReservation;
    }

    @Override
    public TempReservation findByReservationId(Long reservationId) {
        return tempReservationRepository.findByReservationId(reservationId);
    }

    @Override
    public List<TempReservation> findByStoreId(Long storeId) {
        return tempReservationRepository.findByStoreId(storeId);
    }

    @Override
    public List<TempReservation> findByMemberId(Long memberId) {
        return tempReservationRepository.findByMemberId(memberId);
    }

    @Override
    public void deleteTempReservation(Long reservationId) {
        tempReservationRepository.deleteById(reservationId);
    }
}
