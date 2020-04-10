package domain;

import java.util.HashMap;
import java.util.Map;

public class Menus {
    private static final int MAX_MENU_SIZE = 99;

    private Map<Menu, Integer> menus;

    public Menus() {
        this.menus = new HashMap<>();
    }

    public boolean isOrderable(Menu menu, int menuSize) {
        return !(menus.containsKey(menu) && menus.get(menu) + menuSize > MAX_MENU_SIZE);
    }

    public void add(Menu menu, int menuSize) {
        menus.put(menu, menuSize);
    }

    public double calculate() {
        int payAmount = 0;
        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            payAmount = entry.getKey().getPrice() * entry.getValue();
        }

        return payAmount;
    }

    public boolean isEmpty() {
        return menus.isEmpty();
    }
}
