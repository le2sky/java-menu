package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.domain.Coach;
import menu.domain.Menu;
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

    @DisplayName("존재하는 메뉴의 이름만 입력받는다.")
    @Test
    void mapToMenus() {
        String source = "팟타이,뇨끼";

        List<Menu> result = ObjectMapper.mapToMenus(source);

        assertThat(result).hasSize(2);
    }

    @DisplayName("존재하지 않는 메뉴의 이름을 받을 수 없다.")
    @Test
    void mapToMenusWithNonExistMenu() {
        String source = "팟타이,뇨우쓰~끼";

        assertThatThrownBy(() -> ObjectMapper.mapToMenus(source))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
