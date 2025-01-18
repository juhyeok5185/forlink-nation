package com.danny.forlinkbackendspringboot.nation;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Table(name = "t_nation")
public class Nation { // 회원 엔티티

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_nation_id")
    private Integer notionId; // 회원 일련번호

    @Column(name = "code")
    private String code; // 회원 로그인 아이디

    @Column(name = "name")
    private String name; // 회원 이름

}
