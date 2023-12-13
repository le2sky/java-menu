package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;
import java.util.*;

public class MenusData implements Menus {

    private static final String MENU_NOT_FOUND_MESSAGE = "존재하지 않는 메뉴입니다.";

    private final EnumMap<Category, List<Menu>> data = new EnumMap<>(Category.class);
    private final List<Menu> allMenu = new ArrayList<>();

    public MenusData() {
        initData(Category.일식, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        initData(Category.한식, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        initData(Category.중식, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        initData(Category.아시안, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        initData(Category.양식, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }

    private void initData(Category category, String dataString) {
        List<Menu> menus = Arrays.stream(dataString.split(", "))
                .map(name -> new Menu(category, name))
                .toList();

        data.put(category, menus);
        allMenu.addAll(menus);
    }

    @Override
    public boolean contains(Menu menu) {
        return allMenu.contains(menu);
    }

    @Override
    public Menu getBy(String name) {
        return allMenu.stream()
                .filter(menu -> menu.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MENU_NOT_FOUND_MESSAGE));
    }

    @Override
    public Menu pickOne(Category category) {
        List<Menu> selectedMenu = data.get(category);
        List<String> menuNames = selectedMenu.stream()
                .map(Menu::getName)
                .toList();
        String picked = Randoms.shuffle(menuNames).get(0);

        return getBy(picked);
    }
}
