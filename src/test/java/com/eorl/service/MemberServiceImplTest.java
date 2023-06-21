package com.eorl.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.eorl.domain.member.member.Member;
import com.eorl.domain.member.member.MemberSaveForm;
import com.eorl.domain.member.member.MemberType;
import com.eorl.domain.member.member.MemberUpdateForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원가입 테스트")
    void memberJoin() {
        //given
        MemberSaveForm memberSaveForm = new MemberSaveForm(MemberType.CLIENT, "배유연", "1234",
                "01085554444",
                "ddd@maver.com");
        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        //when
        memberService.joinMember(member);
        //then
        Member findMember = memberService.findByMemberId(member.getMemberId());
        assertThat(member.getMemberId()).isEqualTo(findMember.getMemberId());
    }

    @Test
    @DisplayName("중복된 핸드폰번호로 가입하기")
    void duplicatePhoneNumberJoin(){
        //given
        MemberSaveForm memberSaveForm = new MemberSaveForm(MemberType.CLIENT, "배유연", "1234",
                "01085554444",
                "ddd@maver.com");
        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        memberService.joinMember(member);
        //when
        MemberSaveForm memberSaveForm2 = new MemberSaveForm(MemberType.CLIENT, "배유연폰번호중복", "1234",
                "01085554444",
                "ccc@naver.com");
        Member duplicatedMember = new Member(memberSaveForm2.getMemberType(), memberSaveForm2.getName(),
                memberSaveForm2.getPassword(), memberSaveForm2.getPhoneNumber(),
                memberSaveForm2.getEmailAddress());

        //then
        assertThrows(DuplicateKeyException.class,
                () -> memberService.joinMember(duplicatedMember));
    }

    @Test
    @DisplayName("회원 기본정보 수정 테스트")
    void memberUpdate() {

        //given
        MemberSaveForm memberSaveForm = new MemberSaveForm(MemberType.CLIENT, "배유연", "1234",
                "01085554444",
                "ddd@maver.com");
        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        memberService.joinMember(member);
        //when
        MemberUpdateForm memberUpdateForm = new MemberUpdateForm(member.getMemberId(), "배유연복제",
                null, null, null);
        Member updateMember = new Member(memberUpdateForm.getMemberId(),
                memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());

        memberService.updateMember(updateMember);
        //then
        Member findMember = memberService.findByMemberId(member.getMemberId());
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    @DisplayName("회원 핸드폰번호 인증 테스트")
    void updateMemberAuthentication() {
        //given
        MemberSaveForm memberSaveForm = new MemberSaveForm(MemberType.CLIENT, "배유연", "1234", "",
                "ddd@maver.com");
        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        memberService.joinMember(member);
        //when
        MemberUpdateForm memberUpdateForm = new MemberUpdateForm(member.getMemberId(), null, null,
                "01020407777", null);

        memberService.updateMemberAuthentication(memberUpdateForm.getPhoneNumber(),
                memberUpdateForm.getMemberId());
        //then
        Member findMember = memberService.findByMemberId(member.getMemberId());
        assertThat(memberUpdateForm.getPhoneNumber()).isEqualTo(findMember.getPhoneNumber());
    }

    @Test
    @DisplayName("회원탈퇴")
    void deleteMember(){
        //given
        MemberSaveForm memberSaveForm = new MemberSaveForm(MemberType.CLIENT, "배유연", "1234", "",
                "ddd@maver.com");
        Member member = new Member(memberSaveForm.getMemberType(), memberSaveForm.getName(),
                memberSaveForm.getPassword(), memberSaveForm.getPhoneNumber(),
                memberSaveForm.getEmailAddress());
        memberService.joinMember(member);
        //when
        memberService.deleteMember(member.getMemberId());
        //then
        assertThat(memberService.findByMemberId(member.getMemberId())).isEqualTo(null);
    }
}