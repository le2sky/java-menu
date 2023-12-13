package menu;

class OutputView {

    private static final String PRINT_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String PRINT_EXCEPTION_FORMAT = "[ERROR] %s%n";

    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println(PRINT_START_MESSAGE);
    }

    public static void printExceptionMessage(String message) {
        System.out.format(PRINT_EXCEPTION_FORMAT, message);
    }
}
