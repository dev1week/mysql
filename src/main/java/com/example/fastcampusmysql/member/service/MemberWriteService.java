package com.example.fastcampusmysql.member.service;

import com.example.fastcampusmysql.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

    private final MemberRepository memberRepository;



    public Member create(RegisterMemberCommand command){
        /*
            goal : 회원정보 (이메일, 닉네임. 생년월일) 등록
                - 닉네임은 10자 제한
            파라미터 - memberRegisterCommand(dto)
            memberRepository.save(member);
         */


        Member member = Member.builder()
                .nickname(command.nickName())
                .email(command.email())
                .birthDay(command.birthDay())
                .build();

        return memberRepository.save(member);

    }
}
