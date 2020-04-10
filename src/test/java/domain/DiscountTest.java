package domain;

import domain.discount.DiscountMachine;
import domain.discount.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    @DisplayName("치킨 10개 당 10,000원 할인")
    @Test
    void tenDiscount() {
        Menus menus = new Menus();
        Menu menu = MenuRepository.menus().get(1);

        menus.add(menu, 50);

        assertThat(DiscountMachine.calculate(menus, Payment.CARD)).isEqualTo(750_000);
    }

    @DisplayName("현금 할인")
    @Test
    void cashDiscount() {
        Menus menus = new Menus();
        Menu menu = MenuRepository.menus().get(1);

        menus.add(menu, 1);

        assertThat(DiscountMachine.calculate(menus, Payment.CASH)).isEqualTo(15_200);
    }

    @DisplayName("음료 할인 x")
    @Test
    void drinkNoDiscount() {
        Menus menus = new Menus();
        Menu menu = MenuRepository.menus().get(7); //사이다, 1_000원

        menus.add(menu, 50);

        assertThat(DiscountMachine.calculate(menus, Payment.CARD)).isEqualTo(50_000);
    }
}
