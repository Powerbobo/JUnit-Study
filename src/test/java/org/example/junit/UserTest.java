package org.example.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    // 실제 운영할 땐 랜덤 패스워드 생성 메서드를 사용하겠지만, 테스트 코드에선 이를 검증하고 컨트롤하기 위해
    // 구현체를 만들어 주입하여 테스트를 하였다.

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        // user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        // user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "ab");
        // then
        assertThat(user.getPassword()).isNull();
    }
}