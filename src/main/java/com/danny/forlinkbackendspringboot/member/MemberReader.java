package com.danny.forlinkbackendspringboot.member;

import com.danny.forlinkbackendspringboot.common.config.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberReader {

    private final MemberRepository memberRepository;

    public Member findByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new MyException("사용자를 찾을 수 없습니다: " + loginId));
    }


}
