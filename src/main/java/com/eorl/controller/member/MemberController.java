package com.eorl.controller.member;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.member.member.MemberType;
import com.eorl.domain.member.member.MemberUpdateForm;
import com.eorl.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/members")
@RequiredArgsConstructor
@Validated
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     *
     * @param memberSaveForm
     * @return
     */
    @PostMapping
    public Member createMember(@RequestBody @Valid MemberSaveForm memberSaveForm ) {
        Member member = new Member(MemberType.valueOf(memberSaveForm.getMemberType()), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        return memberService.joinMember(member);
    }

    /**
     * 아이디로 멤버 찾기
     *
     * @param memberId
     * @return
     */
    @GetMapping("/{memberId}")
    public Member requestMemberById(@PathVariable int memberId) {
        return memberService.findByMemberId(memberId);
    }


    /**
     * 멤버 기본정보 수정
     *
     * @param memberUpdateForm
     * @return
     */
    @PatchMapping
    public Member updateMember(@RequestBody @Valid MemberUpdateForm memberUpdateForm) {

        Member member = new Member(memberUpdateForm.getMemberId(), memberUpdateForm.getName(),
                memberUpdateForm.getPassword(), memberUpdateForm.getPhoneNumber(),
                memberUpdateForm.getEmailAddress());

        memberService.updateMember(member);
        return member;
    }

    /**
     * 회원 핸드폰번호 인증
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PatchMapping("/authentication/{memberId}")
    public void updateMemberAuthentication(@PathVariable int memberId
            , @RequestParam @Pattern(regexp = "^\\d+$", message = "phoneNumber은 숫자만 입력가능합니다.") String phoneNumber) {

        memberService.updateMemberAuthentication(phoneNumber, memberId);

    }

    /**
     * 멤버 탈퇴
     *
     * @param memberId
     * @return
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable int memberId) {

        memberService.deleteMember(memberId);

    }

}
