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
public class TempReservation {

    @Id
    @Column(nullable = false)
    private int reservationId;

    @Id
    @Column(nullable = false)
    private int storeId;

    @Id
    @Column(nullable = false)
    private int memberId;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;
}
