package com.example.fastcampusmysql.member.repository;

import com.example.fastcampusmysql.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
@Slf4j
public class MemberRepository {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Member save(Member member){
        /*
            member id를 보고 갱신 또는 삽입을 정함
            반환값은 id를 담아서 반환한다.
         */
        if(member.getId() == null){
            return insert(member);
        }

        return update(member);

    }

    private Member insert(Member member){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName("Member")
                //SimpleJdbcInsert 클래스는 자동 생성된 키 컬럼의 이름을 스네이크 케이스 형식으로 변환하여 사용
                //카멜케이스 형식의 필드 이름을 그대로 컬럼 이름으로 사용하고 싶다면, usingColumns 메서드를 사용하여 명시적으로 매핑을 지정
                .usingColumns( "email", "nickname", "birthDay", "createdAt")
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);


        long id = simpleJdbcInsert.executeAndReturnKey(params).longValue();


        return Member
                .builder()
                .id(id)
                .nickname(member.getNickname())
                .email(member.getEmail())
                .birthDay(member.getBirthDay())
                .createdAt(member.getCreatedAt())
                .build();


    }

    private Member update(Member member){
        //to-do
        return member;
    }
}
