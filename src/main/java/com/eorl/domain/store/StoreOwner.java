package com.eorl.domain.store;

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
public class StoreOwner {

    @Id
    @Column(nullable = false)
    private Long storeId;

    @Id
    @Column(nullable = false, length = 100)
    private Long memberId;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;
}
