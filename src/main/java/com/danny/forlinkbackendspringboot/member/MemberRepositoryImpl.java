package com.danny.forlinkbackendspringboot.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import static com.danny.forlinkbackendspringboot.member.QMember.member;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberCustomRepository{

    @Autowired
    private JPAQueryFactory queryFactory;

    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return queryFactory.selectFrom(member).where(member.memberId.eq(memberId)).fetchOne();
    }
}
