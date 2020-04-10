package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @DisplayName("올바른 명령어인지 확인")
    @Test
    void checkCorrectCommand() {
        int command = 123;

        assertThatThrownBy(() -> Command.of(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}