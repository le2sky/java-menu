package menu.domain;

public class Coach {

    private static final int MIN_NAME_LENGTH_RANGE = 2;
    private static final int MAX_NAME_LENGTH_RANGE = 4;
    private static final String INVALID_NAME_LENGTH_RANGE =
            "이름의 길이는 최소 " + MIN_NAME_LENGTH_RANGE + "글자에서 " + MAX_NAME_LENGTH_RANGE + "글자입니다.";

    private final String name;

    public Coach(String name) {
        checkNameLength(name);

        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_RANGE);
        }
    }

    private static boolean isInvalidNameLength(String name) {
        return name.length() < MIN_NAME_LENGTH_RANGE || name.length() > MAX_NAME_LENGTH_RANGE;
    }
}
