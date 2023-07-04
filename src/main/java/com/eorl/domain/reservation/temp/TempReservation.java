package com.eorl.domain.reservation.temp;

import com.eorl.domain.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Getter
@ToString
@NoArgsConstructor
public class TempReservation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long memberId;

    @Column
    private Integer reservationGuestCount;

    public TempReservation(Long storeId, Long memberId, Integer reservationGuestCount) {
        this.storeId = storeId;
        this.memberId = memberId;
        this.reservationGuestCount = reservationGuestCount;
    }
}
