package com.eorl.domain.member.member;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateForm {

    @NotBlank
    private int memberId;

    private String name;

    private String password;

    private String phoneNumber;

    private String emailAddress;

    private LocalDateTime authenticationDatetime;

    public MemberUpdateForm(int memberId, String name, String password, String phoneNumber,
            String emailAddress) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

