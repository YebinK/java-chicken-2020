package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @DisplayName("올바른 명령어인지 확인")
    @Test
    void checkCorrectCommand() {
        String command = "123123";

        assertThatThrownBy(() -> Command.of(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}