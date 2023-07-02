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
        if (memberRepository.findByPhoneNumber(member.getPhoneNumber()).size() > 0) {
            throw new DuplicateKeyException(member.getPhoneNumber()+"는 가입된 핸드폰번호입니다.");
        }
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member findByMemberId(int memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    @Override
    public int updateMember(Member member) {
        log.debug("memberId ::: "+member.getMemberId());
        log.debug("getPassword ::: "+member.getPassword());
        log.debug("getName ::: "+member.getName());
        return memberRepository.updateMemberByMemberId(member.getName(), member.getPassword(),
                 member.getMemberId());
    }

    @Override
    public int updateMemberAuthentication(String phoneNumber, int memberId) {
        return memberRepository.updateMemberAuthentication(phoneNumber, memberId);
    }

    @Override
    public void deleteMember(int memberId) {
        memberRepository.deleteById(memberId);
    }
}
