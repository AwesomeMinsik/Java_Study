package Collection;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    public List<Coffee> List = new ArrayList<>();

    public MenuList(java.util.List<Coffee> list) {
        List = list;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "List=" + List +
                '}';
    }
    public void add(Coffee coffee){
        List.add(coffee);
    }
}
