package com.eorl.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@ToString(exclude = "password")
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="password", nullable = false, length = 100)
    private String password;


    @Column(columnDefinition="DATETIME")
    private LocalDateTime registrationDatetime;

    @Column(columnDefinition="DATETIME")
    private LocalDateTime modificationDatetime;

    @Column(name="phone_number", length = 20)
    private String phoneNumber;

    @Column(name="email_address", length = 100)
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
}

enum MemberType {
    OWNER,
    CLIENT
}
