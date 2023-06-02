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
public class ReservationMenuIngredientDetail {

    @Id
    @Column
    private Long menuIngredientDetailId;

    @Id
    @Column(nullable = false)
    private Long reservationId;

    @Id
    @Column(nullable = false)
    private Long menuId;

    @Id
    @Column(nullable = false)
    private Long menuIngredientId;

    private int count;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}