package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class RecommendationService {

    private final MenuCategories categories;
    private final Menus menus;

    public RecommendationService(MenuCategories menuCategories, Menus menus) {
        this.categories = menuCategories;
        this.menus = menus;
    }

    public List<MenuCategory> recommendCategories() {
        List<MenuCategory> recommended = new ArrayList<>();
        EnumMap<MenuCategory, Integer> counter = createCounter();

        for (int dayOfWeek = 0; dayOfWeek < 5; dayOfWeek++) {
            recommended.add(recommendOneCategory(counter));
        }

        return recommended;
    }

    private EnumMap<MenuCategory, Integer> createCounter() {
        EnumMap<MenuCategory, Integer> counter = new EnumMap<>(MenuCategory.class);

        for (MenuCategory key : MenuCategory.values()) {
            counter.put(key, 0);
        }

        return counter;
    }

    private MenuCategory recommendOneCategory(EnumMap<MenuCategory, Integer> counter) {
        MenuCategory picked = categories.pickOne();

        if (counter.get(picked) < 2) {
            counter.put(picked, counter.get(picked) + 1);
            return picked;
        }

        return recommendOneCategory(counter);
    }


    public List<RecommendResult> recommendMenus(Coaches coaches, List<MenuCategory> recommendedCategories) {
        List<RecommendResult> result = new ArrayList<>();

        for (Coach coach : coaches.getCoaches()) {
            List<Menu> recommendedList = new ArrayList<>();

            for (MenuCategory recommendedCategory : recommendedCategories) {
                recommendedList.add(pickMenu(coach, recommendedCategory, recommendedList));
            }

            result.add(new RecommendResult(coach.getName(), recommendedList));
        }

        return result;
    }

    public Menu pickMenu(Coach coach, MenuCategory category, List<Menu> history) {
        while (true) {
            Menu picked = menus.pickOne(category);

            if (!coach.isHate(picked) && !history.contains(picked)) {
                return picked;
            }
        }
    }
}
