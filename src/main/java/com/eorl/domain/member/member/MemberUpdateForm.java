package com.eorl.domain.member.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateForm {

    @NotNull(message="memberId는 필수입니다.")
    private int memberId;
    @NotNull(message="name은 필수입니다.")
    private String name;

    @NotBlank @NotEmpty(message="password은 필수 입니다.")
    @Length(max=100)
    private String password;

    @Pattern(regexp = "^\\d+$", message = "phoneNumber은 숫자만 입력가능합니다.")
    @Length(max=20)
    private String phoneNumber;

    @Email
    @Length(max=100)
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

