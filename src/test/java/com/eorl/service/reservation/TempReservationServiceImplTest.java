package com.eorl.service.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.reservation.temp.TempReservation;
import com.eorl.domain.reservation.temp.TempReservationSaveForm;
import com.eorl.service.member.MemberService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class TempReservationServiceImplTest {

    @Autowired
    MemberService memberService;
    @Autowired
    TempReservationService tempReservationService;
    Member member = null;

    @BeforeEach
    void before() {
        MemberSaveForm memberSaveForm = new MemberSaveForm("CLIENT", "배유연", "1234",
                "01085554444",
                "ddd@maver.com");
        member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        memberService.joinMember(member);
    }

    @Test
    @DisplayName("예약 신청 테스트")
    void applyReservation() {
        //given
        TempReservationSaveForm tempReservationSaveForm = new TempReservationSaveForm(1L,
                member.getMemberId(), 3);
        TempReservation tempReservation = new TempReservation(tempReservationSaveForm.getStoreId()
                , tempReservationSaveForm.getMemberId(),
                tempReservationSaveForm.getReservationGuestCount());
        //when
        tempReservationService.applyReservation(tempReservation);

        //then
        TempReservation findTempReservation = tempReservationService.findByReservationId(
                tempReservation.getReservationId());
        assertThat(tempReservation.getReservationId()).isEqualTo(
                findTempReservation.getReservationId());
    }

    @Test
    void findByStoreId() {
        //given
        TempReservationSaveForm tempReservationSaveForm = new TempReservationSaveForm(1L,
                member.getMemberId(), 3);

        for (int i = 0; i < 3; i++) {
            TempReservation tempReservation = new TempReservation(
                    tempReservationSaveForm.getStoreId()
                    , tempReservationSaveForm.getMemberId(),
                    tempReservationSaveForm.getReservationGuestCount());
            tempReservationService.applyReservation(tempReservation);
        }
        //when
        List<TempReservation> list = tempReservationService.findByStoreId(1L);
        //then
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void findByMemberId() {
        //given
        TempReservationSaveForm tempReservationSaveForm = new TempReservationSaveForm(1L,
                member.getMemberId(), 3);

        for (int i = 0; i < 4; i++) {
            TempReservation tempReservation = new TempReservation(
                    tempReservationSaveForm.getStoreId()
                    , tempReservationSaveForm.getMemberId(),
                    tempReservationSaveForm.getReservationGuestCount());
            tempReservationService.applyReservation(tempReservation);
        }
        //when
        List<TempReservation> list = tempReservationService.findByMemberId(member.getMemberId());
        //then
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    void deleteTempReservation() {
        //given
        TempReservationSaveForm tempReservationSaveForm = new TempReservationSaveForm(1L,
                member.getMemberId(), 3);
        TempReservation tempReservation = new TempReservation(tempReservationSaveForm.getStoreId()
                , tempReservationSaveForm.getMemberId(),
                tempReservationSaveForm.getReservationGuestCount());

        tempReservationService.applyReservation(tempReservation);
        //when
        tempReservationService.deleteTempReservation(tempReservation.getReservationId());

        //then
        assertThat(tempReservationService.findByReservationId(
                tempReservation.getReservationId())).isEqualTo(null);

    }
}