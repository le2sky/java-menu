package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("이름의 길이는 최소 2글자에서 4글자이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void checkNameLength(int source) {
        assertThatThrownBy(() -> new Coach("*".repeat(source)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
