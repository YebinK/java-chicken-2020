package domain.discount;

public class MenuSize {
    private final int menuSize;

    public MenuSize(int menuSize) {
        this.menuSize = menuSize;
    }

    public int discount() {
        return (menuSize / 10) * 10_000;
    }

    public int get() {
        return menuSize;
    }
}
