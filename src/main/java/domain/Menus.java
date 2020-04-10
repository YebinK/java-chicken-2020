package domain;

import domain.discount.MenuSize;

import java.util.HashMap;
import java.util.Map;

public class Menus {
    private static final int MAX_MENU_SIZE = 99;

    private Map<Menu, MenuSize> menus;

    public Menus() {
        this.menus = new HashMap<>();
    }

    public boolean isOrderable(Menu menu, int menuSize) {
        return !(menus.containsKey(menu) && menus.get(menu).get() + menuSize > MAX_MENU_SIZE);
    }

    public void add(Menu menu, int menuSize) {
        menus.put(menu, new MenuSize(menuSize));
    }

    public int calculate() {
        int payAmount = 0;
        for (Map.Entry<Menu, MenuSize> entry : menus.entrySet()) {
            payAmount = entry.getKey().getPrice() * entry.getValue().get();
        }
        return payAmount;
    }

    public boolean isEmpty() {
        return menus.isEmpty();
    }

    public Map<Menu, MenuSize> get() {
        return menus;
    }

}
