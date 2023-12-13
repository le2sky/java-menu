package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.Coaches;

class Controller {

    public void run() {
        OutputView.printStartMessage();
        Coaches coaches = createCoaches();
    }

    private static Coaches createCoaches() {
        return handle(() -> ObjectMapper.mapToCoaches(InputView.readCoachNames()));
    }
}
