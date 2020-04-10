package domain.table;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableTest {

    Table table;
    Menu menu;

    @BeforeEach
    void setUp() {
        table = TableRepository.tables().get(1);
        menu = MenuRepository.menus().get(1);
    }

    @DisplayName("테이블에 메뉴 99개 이상 주문 시 예외 발생")
    @Test
    void addMenuOver99() {
        assertThatThrownBy(() -> table.add(menu, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결제가 필요한지 확인")
    @Test
    void needToPay() {
        table.add(menu, 1);
        table.validatePayment();

        assertThat(table.needToPay()).isTrue();
    }

    @DisplayName("결제할 수 있는 테이블인지 확인 (결제 불가)")
    @Test
    void validatePayment() {
        assertThatThrownBy(() -> table.validatePayment())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("테이블 출력")
    @Test
    void toStringTest() {
        assertThat(table.toString()).isEqualTo("2");
    }
}