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
public class StoreSetting {

    @Id
    @Column
    private int storeId;

    @Id
    @Column(nullable = false)
    private int maxMemberPerReserve;

    @Id
    @Column(nullable = false)
    private int enableTable;

    @Id
    @Column(nullable = false, length = 1)
    private String menuSelectYn;

    @Id
    @Column(nullable = false, length = 4)
    private String maxWaitingTime;

    @Id
    @Column(nullable = false, length = 1)
    private String reserveYn;

    @Id
    @Column(nullable = false, length = 4)
    private String startWaitingTime;

    @Id
    @Column(nullable = false, length = 4)
    private String endWaitingTime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

     @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;



}
