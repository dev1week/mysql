package com.example.fastcampusmysql.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Member {

    final private Long id;

    private String nickname;

    final private String email;

    private LocalDate birthDay;

    final private LocalDateTime createdAt;

    final private static Long NAME_LIMIT_LENGTH = 10L;

    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthDay, LocalDateTime createdAt) {
        this.id = id;
        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);
        this.email = Objects.requireNonNull(email);
        this.birthDay = Objects.requireNonNull(birthDay);
        this.createdAt = createdAt  == null ?  LocalDateTime.now() : createdAt;
    }

    void validateNickname(String nickname){
        Assert.isTrue(nickname.length() <= NAME_LIMIT_LENGTH, "최대길이를 초과하였습니다.");
    }
}
