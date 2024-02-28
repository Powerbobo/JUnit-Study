package org.example;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // 테스트 코드 작성이 어렵기 때문에 이 부분을 컨트롤 하기 위해서 인터페이스를 생성함.
        // as-is -> 강한 결합
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be -> 낮은 결합 (인터페이스를 사용해서 결합도를 낮춤)
        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */

        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
