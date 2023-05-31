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
public class Store {

    @Id
    @Column
    private int storeId;

    @Id
    @Column(nullable = false, length = 500)
    private String store_name;

    @Id
    @Column(nullable = false, length = 1)
    private String store_status;

    @Id
    @Column(nullable = false, length = 10)
    private String business_number;

    @Id
    @Column(nullable = false, length = 200)
    private String address_main;

    @Id
    @Column(length = 200)
    private String address_detail;

    @Id
    @Column(length = 20)
    private String phone_number;

    @Id
    @Column(length = 500)
    private String store_image;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registration_datetime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modification_datetime;

    @Id
    @Column
    private Float latitude;

    @Id
    @Column
    private Float longitude;
}
