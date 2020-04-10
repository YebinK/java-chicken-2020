package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @DisplayName("주문 명령")
    @Test
    void orderCommand() {
        int command = 1;

        assertThat(Command.of(command)).isEqualTo(Command.ORDER);
    }

    @DisplayName("결제 명령")
    @Test
    void payCommand() {
        int command = 2;

        assertThat(Command.of(command)).isEqualTo(Command.PAY);
    }

    @DisplayName("종료 명령")
    @Test
    void exitCommand() {
        int command = 3;

        assertThat(Command.of(command)).isEqualTo(Command.EXIT);
    }

    @DisplayName("올바른 명령어인지 확인")
    @Test
    void checkCorrectCommand() {
        int command = 123;

        assertThatThrownBy(() -> Command.of(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}