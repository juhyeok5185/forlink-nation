package com.danny.forlinkbackendspringboot.member;

import com.danny.forlinkbackendspringboot.nation.Nation;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private Long memberId; // 회원 일련번호
    private Integer nationId; // 국가 일련번호
    private String loginId; // 회원 로그인 아이디
    private String name; // 회원 이름

    private String nationName;
}
