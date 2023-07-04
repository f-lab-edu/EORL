package com.eorl.controller.member;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.reservation.temp.TempReservation;
import com.eorl.domain.reservation.temp.TempReservationSaveForm;
import com.eorl.service.reservation.TempReservationService;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/tempReservation")
@RequiredArgsConstructor
@Validated
public class TempReservationController {

    private final TempReservationService tempReservationService;

    /**
     * 해당 가게 웨이팅 신청
     * @param tempReservationSaveForm
     * @return
     */
    @PostMapping
    public TempReservation applyTempReservation(
            @RequestBody @Validated TempReservationSaveForm tempReservationSaveForm) {
        TempReservation tempReservation = new TempReservation(tempReservationSaveForm.getStoreId(),
                tempReservationSaveForm.getMemberId(),
                tempReservationSaveForm.getReservationGuestCount());
        return tempReservationService.applyReservation(tempReservation);
    }
    /*@GetMapping("/{reservationId}")
    public TempReservation requestTempReservationId(@PathVariable Long reservationId) {
        Member member = memberService.findByMemberId(memberId);
        if (member == null) {
            throw new NoSuchElementException("아이디가 '" + memberId + "' 멤버는 존재하지 않습니다.");
        }
        return member;
    }*/
}
