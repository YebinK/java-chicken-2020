package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static Table find(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isSameTable(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d는 잘못된 테이븗 번호입니다.", tableNumber)));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
