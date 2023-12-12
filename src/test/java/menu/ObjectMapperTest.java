package menu;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ObjectMapperTest {

    @DisplayName("코치의 이름은 콤마로 구분된다.")
    @Test
    void mapToCoaches() {
        String source = "pobi,lee";

        List<Coach> result = ObjectMapper.mapToCoaches(source);

        assertThat(result).hasSize(2);
    }
}
