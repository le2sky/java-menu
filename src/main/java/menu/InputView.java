package menu;

import camp.nextstep.edu.missionutils.Console;

class InputView {

    private InputView() {
    }

    public static String readCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        return Console.readLine();
    }
}
