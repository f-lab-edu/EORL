package com.eorl.service.member;

import com.eorl.domain.member.member.Member;
import java.util.Optional;

public interface MemberService {

    Member joinMember(Member member);

    Member findByMemberId(Long memberId);

    int updateMember(Member member);

    int updateMemberAuthentication(String phoneNumber, Long memberId);

    void deleteMember(Long memberId);
}
