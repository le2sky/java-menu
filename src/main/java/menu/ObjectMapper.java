package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import java.util.Arrays;


class ObjectMapper {

    private static final String SPLIT_DELIMITER = ",";

    private ObjectMapper() {
    }

    public static Coaches mapToCoaches(String input) {
        return new Coaches(Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(Coach::new)
                .toList());
    }
}
