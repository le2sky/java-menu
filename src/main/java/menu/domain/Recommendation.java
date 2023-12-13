package menu.domain;

import java.util.*;

public class Recommendation {

    private static final int MAX_CATEGORY_RECOMMEND_SIZE = 5;
    private static final int MAX_CATEGORY_DUPLICATION_SIZE = 2;

    private final Categories categories;
    private final Menus menus;

    public Recommendation(Categories categories, Menus menus) {
        this.categories = categories;
        this.menus = menus;
    }

    public List<Category> recommendCategory() {
        EnumMap<Category, Integer> counter = new EnumMap<>(Category.class);
        Arrays.stream(Category.values())
                .forEach(category -> counter.put(category, 0));

        return recommendCategory(counter);
    }

    private List<Category> recommendCategory(EnumMap<Category, Integer> counter) {
        List<Category> selectedCategories = new ArrayList<>();

        while (selectedCategories.size() < MAX_CATEGORY_RECOMMEND_SIZE) {
            Category picked = categories.pickOne();

            if (counter.get(picked) < MAX_CATEGORY_DUPLICATION_SIZE) {
                counter.put(picked, counter.get(picked) + 1);
                selectedCategories.add(picked);
            }
        }

        return selectedCategories;
    }

    public List<RecommendMenuResult> recommendMenu(List<Category> categories, Coaches coaches) {
        List<RecommendMenuResult> result = new ArrayList<>();
        Map<String, List<Menu>> cache = new HashMap<>();
        coaches.getCoaches()
                .forEach(coach -> cache.put(coach.getName(), new ArrayList<>()));

        for (Category category : categories) {
            coaches.getCoaches().forEach(coach -> {
                while (true) {
                    Menu picked = menus.pickOne(category);

                    if (!coach.isHate(picked) && !cache.get(coach.getName()).contains(picked)) {
                        cache.get(coach.getName()).add(picked);
                        break;
                    }
                }
            });
        }

        cache.forEach((name, recommendMenu) -> result.add(new RecommendMenuResult(name, recommendMenu)));
        return result;
    }
}
