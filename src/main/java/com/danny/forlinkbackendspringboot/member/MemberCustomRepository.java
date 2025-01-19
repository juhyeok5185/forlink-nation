package com.danny.forlinkbackendspringboot.member;


public interface MemberCustomRepository {
    Member findMemberById(Long memberId);
}
