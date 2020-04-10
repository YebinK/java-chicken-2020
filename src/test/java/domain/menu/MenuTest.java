package domain.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    Menu chicken;
    Menu sprite;

    @BeforeEach
    void setUp() {
        chicken = new Menu(1, "후라이드 치킨", Category.CHICKEN, 16_000);
        sprite = new Menu(2, "사이다", Category.BEVERAGE, 1_000);
    }

    @DisplayName("치킨인지 확인")
    @Test
    void isChicken() {
        assertThat(chicken.isChicken()).isTrue();
        assertThat(sprite.isChicken()).isFalse();
    }

    @DisplayName("같은 메뉴인지 번호로 확인")
    @Test
    void isSameMenu() {
        assertThat(chicken.isSameMenu(1)).isTrue();
        assertThat(chicken.isSameMenu(2)).isFalse();
    }

    @DisplayName("메뉴 이름 가져오기")
    @Test
    void getName() {
        assertThat(chicken.getName()).isEqualTo("후라이드 치킨");
    }

    @DisplayName("메뉴 출력")
    @Test
    void testToString() {
        assertThat(chicken.toString()).isEqualTo("[치킨] 1 - 후라이드 치킨 : 16000원");
    }
}