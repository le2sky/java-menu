package menu;

import static menu.ExceptionHandler.handle;

import menu.domain.*;
import java.util.List;

class Controller {

    private final RecommendationService recommendationService;

    public Controller(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    public void run() {
        OutputView.printHeader();
        Coaches coaches = createCoaches();
        setHateMenu(coaches);
        List<MenuCategory> categories = recommendationService.recommendCategories();
        OutputView.printResultHeader();
        OutputView.printRecommendedCategories(categories);
    }

    private Coaches createCoaches() {
        return handle(() -> new Coaches(ObjectMapper.mapToCoaches(InputView.readCoachName())));
    }

    private void setHateMenu(Coaches coaches) {
        coaches.getCoaches().forEach(this::setEachHateMenu);
    }

    private void setEachHateMenu(Coach coach) {
        handle(() -> {
            List<Menu> menus = ObjectMapper.mapToMenus(InputView.readHateFood(coach.getName()));
            coach.setHateMenu(menus);

            return menus;
        });
    }
}
