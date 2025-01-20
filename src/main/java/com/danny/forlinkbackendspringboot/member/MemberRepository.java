package com.danny.forlinkbackendspringboot.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> , MemberCustomRepository {

    Optional<Member> findByLoginId(String loginId);

}
