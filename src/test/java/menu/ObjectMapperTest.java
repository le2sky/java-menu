package menu;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.Coaches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ObjectMapperTest {

    @DisplayName("사용자의 입력을 받아서, 코치 목록(Coaches)으로 매핑한다.")
    @Test
    void mapToCoaches() {
        Coaches result = ObjectMapper.mapToCoaches("pobi,lee");

        assertThat(result.getCoaches())
                .hasSize(2);
    }
}
