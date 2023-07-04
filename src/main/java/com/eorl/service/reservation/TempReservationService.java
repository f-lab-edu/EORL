package com.eorl.service.reservation;

import com.eorl.domain.reservation.temp.TempReservation;
import java.util.List;

public interface TempReservationService {

    TempReservation applyReservation(TempReservation tempReservation);

    TempReservation findByReservationId(Long reservationId);

    List<TempReservation> findByStoreId(Long storeId);

    List<TempReservation> findByMemberId(Long memberId);

    void deleteTempReservation(Long reservationId);
}
