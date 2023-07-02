package com.eorl.domain.menu;

import com.eorl.domain.common.EnumConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Getter
@ToString
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(nullable = false)
    private Long storeId;

    @Convert(converter = EnumConverter.class)
    private MenuStatus menuStatus;

    @Column(nullable = false, length = 100)
    private String menuName;

    private BigDecimal price;

    @Column(length = 500)
    private String menuImageUrl;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

    @Builder
    public Menu(Long menuId, Long storeId, MenuStatus menuStatus, String menuName, BigDecimal price,
            String menuImageUrl, LocalDateTime registrationDatetime,
            LocalDateTime modificationDatetime) {
        this.menuId = menuId;
        this.storeId = storeId;
        this.menuStatus = menuStatus;
        this.menuName = menuName;
        this.price = price;
        this.menuImageUrl = menuImageUrl;
        this.registrationDatetime = registrationDatetime;
        this.modificationDatetime = modificationDatetime;
    }
}
