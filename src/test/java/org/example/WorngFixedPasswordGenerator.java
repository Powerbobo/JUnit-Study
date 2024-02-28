package org.example;

// 올바르게 고정된 패스워드 제너레이터를 만들기 위해서 생성함.
public class WorngFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "ab"; // 2글자
    }
}
