package com.eorl.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SocialMember")
@Getter
@ToString
@NoArgsConstructor
public class SocialMember {

    @Id
    @Column(name = "member_id", length = 100)
    private int memberId;

    @Id
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "social_login_id", nullable = false, length = 100)
    private String socialLoginId;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime modificationDatetime;

}
enum SocialType{
    GOOGLE,
    APPLE,
    NAVER
}