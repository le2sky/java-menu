package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class ObjectMapper {

    private static final String SPLIT_DELIMITER = ",";

    private static Menus data;

    private ObjectMapper() {
    }

    public static Coaches mapToCoaches(String input) {
        return new Coaches(Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(Coach::new)
                .toList());
    }

    public static List<Menu> mapToMenus(String input) {
        if (input.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(name -> data.getBy(name))
                .toList();
    }

    public static void setData(Menus menus) {
        data = menus;
    }
}
