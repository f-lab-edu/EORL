package com.eorl.domain.member.member;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveForm {

    @NotBlank
    private MemberType memberType;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private String phoneNumber;

    @NotBlank
    private String emailAddress;

    private LocalDateTime authenticationDatetime;

    public MemberSaveForm(MemberType memberType, String name, String password, String phoneNumber,
            String emailAddress) {
        this.memberType = memberType;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

