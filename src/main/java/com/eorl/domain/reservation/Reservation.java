package com.eorl.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Reservation {

    @Id
    @Column(nullable = false)
    private Long reservationId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long memberId;

    @Column
    private int reservationGuestNumber;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}
