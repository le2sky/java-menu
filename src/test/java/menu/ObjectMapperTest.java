package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.domain.Coaches;
import menu.domain.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ObjectMapperTest {

    @BeforeAll
    static void beforeAll() {
        ObjectMapper.setData(new MenusData());
    }

    @DisplayName("사용자의 입력을 받아서, 코치 목록(Coaches)으로 매핑한다.")
    @Test
    void mapToCoaches() {
        Coaches result = ObjectMapper.mapToCoaches("pobi,lee");

        assertThat(result.getCoaches())
                .hasSize(2);
    }

    @DisplayName("사용자의 입력을 받아서, 메뉴의 목록으로 매핑한다.")
    @Test
    void mapToMenus() {
        List<Menu> result = ObjectMapper.mapToMenus("오니기리,뇨끼");

        assertThat(result).hasSize(2);
    }

    @DisplayName("존재하지 않는 메뉴를 입력하면, 예외를 발생한다.")
    @Test
    void checkNotFoundMenu() {
        assertThatThrownBy(() -> ObjectMapper.mapToMenus("오끼"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이나 빈값을 입력하면, 빈 리스트로 매핑한다.")
    @Test
    void blankStringMapping() {
        List<Menu> result = ObjectMapper.mapToMenus("");

        assertThat(result).isEmpty();
    }
}
