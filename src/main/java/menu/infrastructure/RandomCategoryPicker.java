package menu.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Categories;
import menu.domain.Category;

public class RandomCategoryPicker implements Categories {

    @Override
    public Category pickOne() {
        return Category.get(Randoms.pickNumberInRange(1, 5));
    }
}
