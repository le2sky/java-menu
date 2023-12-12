package menu;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Name;
import menu.infrastructure.AllMenusData;
import java.util.Arrays;
import java.util.List;

class ObjectMapper {

    private ObjectMapper() {
    }

    public static List<Coach> mapToCoaches(String input) {
        List<Name> coachNames = Arrays.stream(input.split(","))
                .map(Name::from)
                .toList();

        return coachNames.stream()
                .map(Coach::new)
                .toList();
    }

    public static List<Menu> mapToMenus(String input) {
        return Arrays.stream(input.split(","))
                .map(AllMenusData::get)
                .toList();
    }
}
