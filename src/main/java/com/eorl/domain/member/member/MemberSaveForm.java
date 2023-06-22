package com.eorl.domain.member.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveForm {

    @NotBlank @NotEmpty(message="memberType은 필수 입니다.")
    private MemberType memberType;

    @NotBlank @NotEmpty(message="name은 필수 입니다.")
    private String name;

    @NotBlank @NotEmpty(message="password은 필수 입니다.")
    private String password;

    @Pattern(regexp = "^\\d+$", message = "phoneNumber은 숫자만 입력가능합니다.")
    private String phoneNumber;

    @Email
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

