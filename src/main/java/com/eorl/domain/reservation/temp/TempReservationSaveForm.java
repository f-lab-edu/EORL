package com.eorl.domain.reservation.temp;

import com.eorl.domain.common.BaseTimeEntity;
import com.eorl.repository.TempReservationRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class TempReservationSaveForm extends BaseTimeEntity {

    @NotBlank(message="storeId은 필수 입니다.")
    private Long storeId;

    @NotBlank(message="memberId은 필수 입니다.")
    private Long memberId;

    private Integer reservationGuestCount;

    public TempReservationSaveForm(Long storeId, Long memberId, Integer reservationGuestCount) {
        this.storeId = storeId;
        this.memberId = memberId;
        this.reservationGuestCount = reservationGuestCount;
    }
}
