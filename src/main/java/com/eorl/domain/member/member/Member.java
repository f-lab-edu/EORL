package com.eorl.domain.member.member;

import com.eorl.domain.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String emailAddress;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime authenticationDatetime;

    public Member(MemberType memberType, String name, String password, String phoneNumber,
            String emailAddress) {
        this.memberType = memberType;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Member(int memberId, MemberType memberType, String name, String password,
            String phoneNumber,
            String emailAddress) {
        this.memberId = memberId;
        this.memberType = memberType;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

