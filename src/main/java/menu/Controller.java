package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.Coach;
import menu.domain.Menu;
import java.util.List;

class Controller {

    public void run() {
        OutputView.printHeader();
        List<Coach> coaches = createCoaches();
        setHateMenu(coaches);
    }

    private List<Coach> createCoaches() {
        return handle(() -> ObjectMapper.mapToCoaches(InputView.readCoachName()));
    }

    private void setHateMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coach.setHateMenu(createHateMenu(coach));
        }
    }

    private List<Menu> createHateMenu(Coach coach) {
        return handle(() -> ObjectMapper.mapToMenus(InputView.readHateFood(coach.getName())));
    }
}
