package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.member.service.MemberWriteService;
import com.example.fastcampusmysql.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class MemberController {

    final private MemberWriteService memberWriteService;

    @PostMapping("/members")
    public Member register(@RequestBody RegisterMemberCommand command){
        return memberWriteService.create(command);
    }
}
