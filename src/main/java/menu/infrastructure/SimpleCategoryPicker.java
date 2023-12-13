package menu.infrastructure;

import menu.domain.Categories;
import menu.domain.Category;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleCategoryPicker implements Categories {

    private Queue<Category> queue = new LinkedList<>();

    public void setData(List<Category> categories) {
        queue.addAll(categories);
    }

    @Override
    public Category pickOne() {
        return queue.poll();
    }
}
