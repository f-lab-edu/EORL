package com.eorl.domain.menu;

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
public class MenuIngredientDetail {

    @Id
    @Column(nullable = false)
    private int menuIngredientDetailId;

    @Id
    @Column(nullable = false)
    private int menuIngredientId;

    @Id
    @Column(nullable = false)
    private int storeId;

    @Id
    @Column(nullable = false)
    private int menuId;

    @Id
    @Column(length = 100)
    private int menuIngredientName;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;
}
