package domain.table;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @DisplayName("존재하는 테이블을 찾을 때")
    @Test
    void exists() {
        final Table table = new Table(1);

        assertThat(TableRepository.find(1)).isEqualTo(table);
    }

    @DisplayName("존재하지 않는 테이블을 찾을 때")
    @Test
    void notExists() {
        assertThatThrownBy(() -> TableRepository.find(7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}