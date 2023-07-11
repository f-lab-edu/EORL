package com.eorl.domain.member.member;

import com.eorl.domain.common.validator.EnumValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveForm {

    @EnumValue(enumClass = MemberType.class, message = "유효하지 않은 멤버타입입니다.")
    private String memberType;

    public MemberType getMemberType() {
        return MemberType.valueOf(memberType);
    }

    @NotBlank
    @NotEmpty(message = "name은 필수 입니다.")
    @Length(max = 100)
    private String name;

    @NotBlank
    @NotEmpty(message = "password은 필수 입니다.")
    @Length(max = 100)
    private String password;

    @Pattern(regexp = "^\\d+$", message = "phoneNumber은 숫자만 입력가능합니다.")
    @Length(max = 20)
    private String phoneNumber;


    @Email
    @Length(max = 100)
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

