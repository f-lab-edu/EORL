package com.eorl.domain.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

@Entity
@Table
@Getter
@ToString
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false, length = 500)
    private String storeName;

    @Column(nullable = false, length = 1)
    private String storeStatus;

    @Column(nullable = false, length = 10)
    private String businessNumber;

    @Column(nullable = false, length = 200)
    private String addressMain;

    @Column(length = 200)
    private String addressDetail;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 500)
    private String storeImageUrl;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

    //Point 형으로 변경
    @Column(nullable = false, columnDefinition = "GEOMETRY")
    private Point location;

}
