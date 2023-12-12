package menu.domain;

import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        checkCoachesSize(coaches);
        checkCoachesDuplication(coaches);

        this.coaches = coaches;
    }

    private void checkCoachesSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께해야 합니다.");
        }
    }

    private void checkCoachesDuplication(List<Coach> coaches) {
        if (calculateUniqueCoachesSize(coaches) != coaches.size()) {
            throw new IllegalArgumentException("중복 코치가 포함되어 있습니다.");
        }
    }

    private int calculateUniqueCoachesSize(List<Coach> coaches) {
        return coaches.stream()
                .distinct()
                .toList()
                .size();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
