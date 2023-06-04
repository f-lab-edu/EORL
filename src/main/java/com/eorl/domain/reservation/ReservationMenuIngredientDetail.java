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
    private Long menuIngredientDetailId;

    @Id
    private Long reservationId;

    @Id
    private Long menuId;

    @Id
    private Long menuIngredientId;

    private Integer count;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}
