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
public class ReservationMenu {

    @Id
    @Column(nullable = false)
    private Long reservationId;

    @Id
    @Column(nullable = false)
    private Long menuId;

    private int menuCount;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}
