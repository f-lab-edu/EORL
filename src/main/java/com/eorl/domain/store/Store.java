package com.eorl.domain.store;

import com.eorl.domain.common.EnumConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false, length = 500)
    private String storeName;

    @Convert(converter = EnumConverter.class)
    private StoreStatus storeStatus;

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

    @Builder
    public Store(Long storeId, String storeName, StoreStatus storeStatus, String businessNumber,
            String addressMain, String addressDetail, String phoneNumber, String storeImageUrl,
            LocalDateTime registrationDatetime, LocalDateTime modificationDatetime,
            Point location) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeStatus = storeStatus;
        this.businessNumber = businessNumber;
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.phoneNumber = phoneNumber;
        this.storeImageUrl = storeImageUrl;
        this.registrationDatetime = registrationDatetime;
        this.modificationDatetime = modificationDatetime;
        this.location = location;
    }
}
