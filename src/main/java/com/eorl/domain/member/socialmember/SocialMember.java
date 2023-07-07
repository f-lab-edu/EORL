package com.eorl.domain.member.socialmember;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "social_member")
@Getter
@ToString
@NoArgsConstructor
public class SocialMember {

    @Id
    @Column
    private Long memberId;

    @Id
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(nullable = false, length = 100)
    private String socialLoginId;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime modificationDatetime;

}
