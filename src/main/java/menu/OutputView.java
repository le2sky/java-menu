package menu;

import menu.domain.Menu;
import menu.domain.MenuCategory;
import menu.domain.RecommendResult;
import java.util.List;
import java.util.stream.Collectors;

class OutputView {

    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String RECOMMENDED_CATEGORY_FORMAT = "[ 카테고리 | %s ]%n";
    private static final String RECOMMENDED_MENU_FORMAT = "[ %s | %s ]%n";

    private OutputView() {
    }

    public static void printExceptionMessage(String message) {
        System.out.format(EXCEPTION_MESSAGE_FORMAT, message);
    }

    public static void printHeader() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResultHeader() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printRecommendedCategories(List<MenuCategory> categories) {
        String recommendedCategories = categories.stream()
                .map(Enum::name)
                .collect(Collectors.joining(" | "));

        System.out.format(RECOMMENDED_CATEGORY_FORMAT, recommendedCategories);
    }

    public static void printRecommendedMenu(List<RecommendResult> results) {
        for (RecommendResult result : results) {
            System.out.format(RECOMMENDED_MENU_FORMAT, result.coachName(), buildMenuMessage(result));
        }

        System.out.println("추천을 완료했습니다.");
    }

    private static String buildMenuMessage(RecommendResult result) {
        return result.recommendedMenus().stream()
                .map(Menu::getName)
                .collect(Collectors.joining(" | "));
    }
}
