package com.eorl.domain.member.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateForm {

    @NotNull(message="memberId는 필수입니다.")
    private Long memberId;
    @NotNull(message="name은 필수입니다.")
    private String name;

    private String password;

    private String phoneNumber;

    private String emailAddress;

    private LocalDateTime authenticationDatetime;

    public MemberUpdateForm(Long memberId, String name, String password, String phoneNumber,
            String emailAddress) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

