package com.eorl.domain.store.dto;

import com.eorl.domain.store.Store;
import com.eorl.domain.store.StoreStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@NoArgsConstructor
public class StoreRequestDto {

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
    public Store StoreRequestDto() {
        return Store.builder()
                .storeId(this.storeId)
                .storeName(this.storeName)
                .storeStatus(this.storeStatus)
                .businessNumber(this.businessNumber)
                .addressMain(this.addressMain)
                .addressDetail(this.addressDetail)
                .phoneNumber(this.phoneNumber)
                .storeImageUrl(this.storeImageUrl)
                .location(this.location)
                .build();
    }
}
