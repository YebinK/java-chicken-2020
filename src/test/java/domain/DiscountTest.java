package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @DisplayName("10개 당 10,000원 할인")
    @Test
    void cashDiscount() {
        Table table = TableRepository.tables().get(1);
        Menu menu = MenuRepository.menus().get(1);
        table.add(menu, 50);

        AssertThat(table.)
    }
}
