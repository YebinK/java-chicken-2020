package domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @DisplayName("존재하는 메뉴를 찾을 때")
    @Test
    void find() {
        final Menu selected = new Menu(21, "콜라", Category.BEVERAGE, 1_000); //MenuRepository 에 존재

        assertThat(MenuRepository.find(21)).isEqualTo(selected);
    }

    @DisplayName("존재하지 않는 메뉴를 찾을 때")
    @Test
    void findNone() {
        assertThatThrownBy(() -> MenuRepository.find(20))
                .isInstanceOf(IllegalArgumentException.class);
    }
}