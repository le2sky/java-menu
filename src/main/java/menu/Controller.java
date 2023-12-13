package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import java.util.List;

class Controller {

    private final Menus menus;

    public Controller(Menus menus) {
        ObjectMapper.setData(menus);

        this.menus = menus;
    }

    public void run() {
        OutputView.printStartMessage();
        Coaches coaches = createCoaches();

        for (Coach coach : coaches.getCoaches()) {
            setHateMenus(coach);
        }
    }

    private static Coaches createCoaches() {
        return handle(() -> ObjectMapper.mapToCoaches(InputView.readCoachNames()));
    }

    private static void setHateMenus(Coach coach) {
        handle(() -> {
            List<Menu> hateMenus = ObjectMapper.mapToMenus(InputView.readCoachHateMenus(coach.getName()));
            coach.setHateMenus(hateMenus);

            return coach;
        });
    }
}
