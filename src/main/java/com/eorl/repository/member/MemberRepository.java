package com.eorl.repository.member;

import com.eorl.domain.member.member.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberId(Long memberId);

    List<Member> findByPhoneNumber(String phoneNumber);

    /**
     * 회원기본정보 수정
     *
     * @param name
     * @param password
     * @param memberId
     */
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Member m "
            + "SET m.name=COALESCE(:name, m.name),"
            + "m.password=COALESCE(:password, m.password)"
            + "WHERE m.memberId = :memberId")
    int updateMemberByMemberId(@Param("name") String name, @Param("password") String password,
            @Param("memberId") Long memberId);

    /**
     * 회원 핸드폰번호 인증시 인증일자, 핸드폰번호 업데이트
     *
     * @param phoneNumber
     * @param memberId
     * @return
     */
    @Query("UPDATE Member m "
            + "SET m.phoneNumber = :phoneNumber,"
            + "m.authenticationDatetime = current_timestamp "
            + "WHERE m.memberId = :memberId")
    @Modifying(clearAutomatically = true)
    @Transactional
    int updateMemberAuthentication(@Param("phoneNumber") String phoneNumber,
            @Param("memberId") Long memberId);


}
