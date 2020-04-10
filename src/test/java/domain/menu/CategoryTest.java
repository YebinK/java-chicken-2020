package domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @DisplayName("치킨 출력")
    @Test
    void chickenToString() {
        assertThat(Category.CHICKEN.toString()).isEqualTo("[치킨]");
    }

    @DisplayName("음료 출력")
    @Test
    void beverageToString() {
        assertThat(Category.BEVERAGE.toString()).isEqualTo("[음료]");
    }
}