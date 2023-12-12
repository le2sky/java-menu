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
            setEachHateMenu(coach);
        }
    }

    private void setEachHateMenu(Coach coach) {
        handle(() -> {
            List<Menu> menus = ObjectMapper.mapToMenus(InputView.readHateFood(coach.getName()));
            coach.setHateMenu(menus);

            return menus;
        });
    }
}
