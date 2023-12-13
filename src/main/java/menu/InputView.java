package menu;

import camp.nextstep.edu.missionutils.Console;

class InputView {

    private static final String READ_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_COACH_HATE_MENUS_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    private InputView() {
    }

    public static String readCoachNames() {
        System.out.println(READ_COACH_NAME_MESSAGE);

        return Console.readLine().trim();
    }

    public static String readCoachHateMenus(String name) {
        System.out.format(READ_COACH_HATE_MENUS_MESSAGE, name);

        return Console.readLine().trim();
    }
}
