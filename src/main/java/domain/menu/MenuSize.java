package domain.menu;

public class MenuSize {
    private static final int DISCOUNT_UNIT = 10;
    private static final int DISCOUNT_RATE = 10_000;

    private final int menuSize;

    public MenuSize(int menuSize) {
        this.menuSize = menuSize;
    }

    public int discount() {
        return (menuSize / DISCOUNT_UNIT) * DISCOUNT_RATE;
    }

    public int get() {
        return menuSize;
    }
}
