package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("이름 생성 테스트")
    @Test
    void create() {
        Name pobi = Name.from("pobi");
        Name other = Name.from("pobi");

        assertThat(pobi).isEqualTo(other);
    }

    @DisplayName("코치의 이름은 최소 2글자, 최대 4글자이다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void checkNameLength(int source) {
        String repeated = "*".repeat(source);

        assertThatThrownBy(() -> Name.from(repeated))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
