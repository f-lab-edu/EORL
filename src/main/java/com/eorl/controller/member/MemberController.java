package com.eorl.controller.member;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.member.member.MemberUpdateForm;
import com.eorl.service.MemberService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     *
     * @param memberSaveForm
     * @param bindingResult
     * @return
     */
    @PostMapping
    public Member createMember(@Valid @RequestBody(required = true) MemberSaveForm memberSaveForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.getAllErrors().toString());
        }

        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
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
    @GetMapping("/memberId/{memberId}")
    public List<Member> requestMemberById(@PathVariable int memberId) {
        List<Member> members = new ArrayList<>();
        Member member = memberService.findByMemberId(memberId);
        if (member == null) {
            throw new NoSuchElementException("아이디가 '" + memberId + "' 멤버는 존재하지 않습니다.");
        }
        members.add(member);
        return members;
    }


    /**
     * 멤버 기본정보 수정
     *
     * @param memberUpdateForm
     * @return
     */
    @PatchMapping
    public Member updateMember(@RequestBody(required = true) MemberUpdateForm memberUpdateForm) {

        if (memberService.findByMemberId(memberUpdateForm.getMemberId()) == null) {
            throw new NoSuchElementException("수정하려는 아이디가 존재하지 않습니다.");
        }
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
    @PatchMapping("/memberId/{memberId}")
    public void updateMemberAuthentication(@PathVariable int memberId,  @RequestBody String phoneNumber) {

        if (memberService.findByMemberId(memberId) == null) {
            throw new NoSuchElementException("수정하려는 아이디가 존재하지 않습니다.");
        }

        memberService.updateMemberAuthentication(phoneNumber, memberId);
        //해당 컨트롤러 이제 테스트 진행하면됨!
    }

    /**
     * 멤버 탈퇴
     *
     * @param memberId
     * @return
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/memberId/{memberId}")
    public void deleteMember(@PathVariable int memberId) {

        if (memberService.findByMemberId(memberId) == null) {
            throw new NoSuchElementException("삭제하려는 아이디가 존재하지 않습니다.");
        }

    }

}
