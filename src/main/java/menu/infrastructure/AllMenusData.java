package menu.infrastructure;

import menu.domain.Menu;
import menu.domain.MenuCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllMenusData {

    private static final List<Menu> store = new ArrayList<>();
    private static final List<String> menuNames = new ArrayList<>();

    static {
        init(MenuCategory.일식, "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼");
        init(MenuCategory.한식, "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음");
        init(MenuCategory.중식, "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채");
        init(MenuCategory.아시안, "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜");
        init(MenuCategory.양식, "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니");
    }

    private static void init(MenuCategory menuCategory, String namesData) {
        String[] splitNamesData = namesData.split(",");
        menuNames.addAll(Arrays.stream(splitNamesData).toList());

        for (String menuName : splitNamesData) {
            store.add(new Menu(menuName, menuCategory));
        }
    }

    public static Menu get(String menuName) {
        return store.stream()
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }
}
