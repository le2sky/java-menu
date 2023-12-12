package menu;

import camp.nextstep.edu.missionutils.Console;

class InputView {

    private static final String READ_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_HATE_MENU_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    private InputView() {
    }

    public static String readCoachName() {
        System.out.println(READ_COACH_NAME_MESSAGE);

        return Console.readLine();
    }

    public static String readHateFood(String coachName) {
        System.out.format(READ_HATE_MENU_FORMAT, coachName);

        return Console.readLine();
    }
}
