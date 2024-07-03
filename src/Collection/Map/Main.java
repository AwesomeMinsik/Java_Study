package Collection.Map;

import Collection.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    Coffee coffee1 = new Coffee("아메리카노","맛있음",2000);
    Coffee coffee2 = new Coffee("라떼","맛있음",3000);

    Map<Integer, Coffee> map = new HashMap<>();
    map.put(0,coffee1);

    MenuMap coffeeMap = new MenuMap(map);

    coffeeMap.setMap(1,coffee2);

    }
}
