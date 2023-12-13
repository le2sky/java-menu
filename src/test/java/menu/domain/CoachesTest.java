package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;

class CoachesTest {

    @DisplayName("코치의 인원수는 2명에서 5명 사이이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void checkCoachCount(int source) {
        List<Coach> coaches = new ArrayList<>();
        for (int count = 0; count < source; count++) {
            coaches.add(new Coach("ex" + count));
        }

        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 코치는 존재할 수 없다.")
    @Test
    void checkCoachDuplication() {
        List<Coach> coaches = List.of(
                new Coach("pobi"),
                new Coach("pobi")
        );

        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
