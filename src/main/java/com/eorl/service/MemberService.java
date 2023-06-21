package com.eorl.service;

import com.eorl.domain.member.member.Member;
import java.util.Optional;

public interface MemberService {

    Member joinMember(Member member);

    Member findByMemberId(int memberId);

    int updateMember(Member member);

    int updateMemberAuthentication(String phoneNumber, int memberId);

    void deleteMember(int memberId);
}
