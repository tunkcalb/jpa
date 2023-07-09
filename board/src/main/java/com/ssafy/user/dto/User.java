package com.ssafy.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;

@Entity(name="user")
public class User {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-z0-9]{6,20}", message = "아이디는 6~20자의 영문 소문자, 숫자만 사용 가능합니다.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d])(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]*$",
            message = "비밀번호는 영문 소문자, 영문 대문자, 숫자, 특수문자를 하나씩 포함해야합니다.")
    private String password;

}
