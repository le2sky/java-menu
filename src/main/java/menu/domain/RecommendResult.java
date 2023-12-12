package menu.domain;

import java.util.List;

public record RecommendResult(String coachName, List<Menu> recommendedMenus) {
}
