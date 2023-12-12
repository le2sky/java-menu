package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class CoachesTest {

    @DisplayName("코치는 최소 2명, 최대 5명까지 식사를 함께 한다.")
    @Test
    void checkCoachesSize() {
        List<Coach> coaches = List.of(new Coach(Name.from("pobi")));

        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 코치는 존재할 수 없다.")
    @Test
    void checkCoachesDuplication() {
        List<Coach> coaches = List.of(
                new Coach(Name.from("pobi")),
                new Coach(Name.from("pobi")));

        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
