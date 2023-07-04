package com.eorl.service;

import com.eorl.domain.member.member.Member;
import com.eorl.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

@Slf4j
//@Service
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(Member member) {

        //이미 해당 핸드폰번호로 등록한 유저이면 가입 불가.
        if (member.getPhoneNumber() != null
                && memberRepository.findByPhoneNumber(member.getPhoneNumber()).size() > 0) {
            throw new DuplicateKeyException(member.getPhoneNumber() + "는 가입된 핸드폰번호입니다.");
        }
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member findByMemberId(Long memberId) {
        Member member = memberRepository.findByMemberId(memberId);
        if (member == null) {
            throw new NoSuchElementException("아이디가 '" + memberId + "' 멤버는 존재하지 않습니다.");
        }
        return member;
    }

    @Override
    public int updateMember(Member member) {
        if (memberRepository.findByMemberId(member.getMemberId()) == null) {
            throw new NoSuchElementException("아이디가 '" + member.getMemberId() + "' 멤버는 존재하지 않습니다.");
        }

        int result = memberRepository.updateMemberByMemberId(member.getName(), member.getPassword(),
                member.getMemberId());
        if (result != 1) {
            throw new RuntimeException("업데이트 중 오류가 발생하였습니다.");
        }
        return result;
    }

    @Override
    public int updateMemberAuthentication(String phoneNumber, Long memberId) {
        if (memberRepository.findByMemberId(memberId) == null) {
            throw new NoSuchElementException("아이디가 '" + memberId + "' 멤버는 존재하지 않습니다.");
        }
        int result = memberRepository.updateMemberAuthentication(phoneNumber, memberId);
        if (result != 1) {
            throw new RuntimeException("업데이트 중 오류가 발생하였습니다.");
        }
        return result;
    }

    @Override
    public void deleteMember(Long memberId) {

        if (memberRepository.findByMemberId(memberId) == null) {
            throw new NoSuchElementException("아이디가 '" + memberId + "' 멤버는 존재하지 않습니다.");
        }

        memberRepository.deleteById(memberId);
    }
}
