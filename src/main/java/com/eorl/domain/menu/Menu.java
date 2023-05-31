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
public class Menu {

    @Id
    @Column(nullable = false)
    private int menuId;

    @Id
    @Column(nullable = false)
    private int storeId;

    @Id
    @Column(nullable = false)
    private String menuStatus;

    @Id
    @Column(nullable = false)
    private String menuName;

    @Id
    @Column
    private int price;

    @Id
    @Column(length = 500)
    private String menuImage;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime registrationDatetime;

    @Id
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modificationDatetime;

}
