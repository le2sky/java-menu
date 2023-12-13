package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

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
}
