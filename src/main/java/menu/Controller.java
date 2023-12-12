package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.Coach;
import java.util.List;

class Controller {

    public void run() {
        OutputView.printHeader();
        List<Coach> coaches = createCoaches();
    }

    private static List<Coach> createCoaches() {
        return handle(() -> ObjectMapper.mapToCoaches(InputView.readCoachName()));
    }
}
