package com.ssafy.user.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user")
public class User {

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Min(6)
    @Max(20)
    @Pattern(regexp = "^[a-z0-9]", message = "아이디는 6~20자의 영문 소문자, 숫자만 사용 가능합니다.")
    private String userName;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Min(8)
    @Max(20)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d])(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]*$",
            message = "비밀번호는 영문 소문자, 영문 대문자, 숫자, 특수문자를 하나씩 포함해야합니다.")
    private String password;

}
