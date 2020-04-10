import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableTest {

    @DisplayName("테이블에 메뉴 추가")
    @Test
    void addMenu() {
        Table table = TableRepository.tables().get(1);
        Menu menu = MenuRepository.menus().get(1);
        table.add(menu, 1);

        assertThat(table.calculate()).isEqualTo(16_000);
    }

    @DisplayName("테이블에 메뉴 99개 이상 주문 시 예외 발생")
    @Test
    void addMenuOver99() {
        Table table = TableRepository.tables().get(1);
        Menu menu = MenuRepository.menus().get(1);

        assertThatThrownBy(() -> table.add(menu, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}