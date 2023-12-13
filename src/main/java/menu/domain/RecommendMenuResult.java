package menu.domain;

import java.util.List;

public record RecommendMenuResult(String coachName, List<Menu> recommendMenu) {
}
