package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.*;
import java.util.List;

class Controller {

    private final Recommendation recommendation;

    public Controller(Menus menus, Categories categories) {
        this.recommendation = new Recommendation(categories, menus);
    }

    public void run() {
        OutputView.printStartMessage();
        Coaches coaches = createCoaches();
        for (Coach coach : coaches.getCoaches()) {
            setHateMenus(coach);
        }

        recommendMenu(coaches);
    }

    private void recommendMenu(Coaches coaches) {
        List<Category> categories = recommendation.recommendCategory();

        OutputView.printResultHeader();
        OutputView.printCategory(categories);
        OutputView.printRecommendMenusResult(recommendation.recommendMenu(categories, coaches));
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
