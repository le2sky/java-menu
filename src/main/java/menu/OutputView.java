package menu;

import menu.domain.Category;
import java.util.List;
import java.util.stream.Collectors;

class OutputView {

    private static final String PRINT_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String PRINT_EXCEPTION_FORMAT = "[ERROR] %s%n";
    private static final String PRINT_RESULT_START_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String PRINT_RESULT_ROW_DESCRIPTION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_CATEGORY_FORMAT = "[ 카테고리 | %s ]%n";
    private static final String CATEGORY_JOIN_DELIMITER = " | ";
    private static final String PRINT_RESULT_END_MESSAGE = "추천을 완료했습니다.";

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(PRINT_START_MESSAGE);
    }

    public static void printExceptionMessage(String message) {
        System.out.format(PRINT_EXCEPTION_FORMAT, message);
    }

    public static void printResultHeader() {
        System.out.println(PRINT_RESULT_START_MESSAGE);
        System.out.println(PRINT_RESULT_ROW_DESCRIPTION);
    }

    public static void printCategory(List<Category> categories) {
        System.out.format(PRINT_CATEGORY_FORMAT, buildCategoryMessage(categories));
    }

    private static String buildCategoryMessage(List<Category> categories) {
        return categories.stream()
                .map(Enum::name)
                .collect(Collectors.joining(CATEGORY_JOIN_DELIMITER));
    }

    public static void printRecommendMenusResult() {
        System.out.println(PRINT_RESULT_END_MESSAGE);
    }
}
