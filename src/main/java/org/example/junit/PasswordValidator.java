package org.example.junit;

public class PasswordValidator {

    public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";

    public static void validate(String password) {

        // if(password.length() < 8 || password.length() > 12) {
        // 위 코드를 아래코드와 같이 리팩토링을 함.
        // 테스트 코드이기 때문에 리팩토링이 자유로움.
        int length = password.length();
        if(length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
