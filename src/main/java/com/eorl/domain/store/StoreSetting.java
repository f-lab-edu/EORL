package com.eorl.domain.store;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
public class StoreSetting {

    @Id
    private Long storeId;

    @Column(nullable = false)
    private int maxMemberPerReserve;

    @Column(nullable = false)
    private int enableTable;

    @Column(nullable = false)
    @Convert(converter = org.hibernate.type.YesNoConverter.class) //encodes a boolean value as 'Y' or 'N'
    private boolean menuSelectYn;

    @Column(nullable = false, length = 4)
    private String maxWaitingTime;

    @Column(nullable = false)
    @Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean reserveYn;

    @Column(nullable = false, length = 4)
    private String startWaitingTime;

    @Column(nullable = false, length = 4)
    private String endWaitingTime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}
