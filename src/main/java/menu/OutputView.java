package menu;

import menu.domain.MenuCategory;
import java.util.List;
import java.util.stream.Collectors;

class OutputView {

    private static final String RECOMMENDED_CATEGORY_FORMAT = "[ 카테고리 | %s ]%n";

    private OutputView() {
    }

    public static void printHeader() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
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
}
