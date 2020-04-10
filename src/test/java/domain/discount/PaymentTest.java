package domain.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {
    @DisplayName("카드 선택")
    @Test
    void card() {
        int inputNumber = 1;

        assertThat(Payment.of(inputNumber)).isEqualTo(Payment.CARD);
    }

    @DisplayName("현금 선택")
    @Test
    void cash() {
        int inputNumber = 2;

        assertThat(Payment.of(inputNumber)).isEqualTo(Payment.CASH);
    }

    @DisplayName("잘못된 입력")
    @Test
    void none() {
        int inputNumber = 123;

        assertThatThrownBy(() -> Payment.of(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}