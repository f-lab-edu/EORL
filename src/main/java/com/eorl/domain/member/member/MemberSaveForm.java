package com.eorl.domain.member.member;

import com.eorl.domain.common.validator.EnumValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveForm {

    //@NotNull(message="memberType은 필수 입니다.")
    @EnumValue(enumClass = MemberType.class, message = "유효하지 않은 멤버타입입니다.", ignoreCase = true)
    private String memberType;

    @NotBlank @NotEmpty(message="name은 필수 입니다.")
    private String name;

    @NotBlank @NotEmpty(message="password은 필수 입니다.")
    private String password;

    @Pattern(regexp = "^\\d+$", message = "phoneNumber은 숫자만 입력가능합니다.")
    private String phoneNumber;

    @Email
    private String emailAddress;

    private LocalDateTime authenticationDatetime;

    public MemberSaveForm(String memberType, String name, String password, String phoneNumber,
            String emailAddress) {
        this.memberType = memberType;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

