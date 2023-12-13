package menu.domain;

import java.util.List;

public class Coaches {

    private static final int MIN_COACHES_SIZE = 2;
    private static final int MAX_COACHES_SIZE = 5;
    private static final String INVALID_COACHES_SIZE_MESSAGE =
            "코치의 인원수는 " + MIN_COACHES_SIZE + "명에서 " + MAX_COACHES_SIZE + "명 사이입니다.";
    private static final String DUPLICATED_COACHES_MESSAGE = "중복된 코치를 포함하고 있습니다.";

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);

        this.coaches = coaches;
    }

    private static void validate(List<Coach> coaches) {
        checkCoachesSize(coaches);
        checkCoachesDuplication(coaches);
    }

    private static void checkCoachesSize(List<Coach> coaches) {
        if (isInvalidCoachesSize(coaches)) {
            throw new IllegalArgumentException(INVALID_COACHES_SIZE_MESSAGE);
        }
    }

    private static boolean isInvalidCoachesSize(List<Coach> coaches) {
        return coaches.size() < MIN_COACHES_SIZE || coaches.size() > MAX_COACHES_SIZE;
    }

    private static void checkCoachesDuplication(List<Coach> coaches) {
        if (hasDuplication(coaches)) {
            throw new IllegalArgumentException(DUPLICATED_COACHES_MESSAGE);
        }
    }

    private static boolean hasDuplication(List<Coach> coaches) {
        return calculateUniqueSize(coaches) != coaches.size();
    }

    private static int calculateUniqueSize(List<Coach> coaches) {
        return coaches.stream()
                .distinct()
                .toList()
                .size();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
