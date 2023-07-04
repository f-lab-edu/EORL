package com.eorl.repository;

import com.eorl.domain.reservation.temp.TempReservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempReservationRepository extends JpaRepository<TempReservation, Long> {
    TempReservation findByReservationId(Long reservationId);
    List<TempReservation> findByStoreId(Long storeId);
    List<TempReservation> findByMemberId(Long memberId);


}
