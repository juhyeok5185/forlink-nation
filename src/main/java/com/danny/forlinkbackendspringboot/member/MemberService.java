package com.danny.forlinkbackendspringboot.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    public void save(){

    }

}
