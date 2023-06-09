package com.example.fastcampusmysql.member.dto;

import java.time.LocalDate;

//record 활용시, command.getNickName();이 아닌 command.nickName으로 연결 가능함
//getter setter 자동으로 부착됨
public record RegisterMemberCommand(
        String email,
        String nickName,
        LocalDate birthDay
) {

}
