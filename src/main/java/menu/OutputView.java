package menu;

class OutputView {

    private OutputView() {
    }

    public static void printHeader() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
