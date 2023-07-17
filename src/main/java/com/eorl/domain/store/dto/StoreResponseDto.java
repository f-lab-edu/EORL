package com.eorl.domain.store.dto;

import com.eorl.domain.store.Store;
import com.eorl.domain.store.StoreStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Data
@NoArgsConstructor
public class StoreResponseDto {

    private Long storeId;
    private String storeName;
    private StoreStatus storeStatus;
    private String businessNumber;
    private String addressMain;
    private String addressDetail;
    private String phoneNumber;
    private String storeImageUrl;
    private Point location;

    @Builder
    public StoreResponseDto(String storeName, StoreStatus storeStatus, String businessNumber,
            String addressMain, String addressDetail, String phoneNumber, String storeImageUrl,
            Point location) {
        this.storeName = storeName;
        this.storeStatus = storeStatus;
        this.businessNumber = businessNumber;
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.phoneNumber = phoneNumber;
        this.storeImageUrl = storeImageUrl;
        this.location = location;
    }
}
