package com.eorl.domain.menu;

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

@Entity
@Table
@Getter
@ToString
@NoArgsConstructor
public class MenuIngredientDetail {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuIngredientDetailId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long menuId;

    @Column(nullable = false)
    private Long menuIngredientId;

    @Column(length = 100)
    private String detailName;

    private int detailPrice;

    @Column(length = 500)
    private String menuImageUrl;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;
}
