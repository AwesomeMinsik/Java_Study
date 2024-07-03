package Collection.Wrapper;

import Collection.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControlledList {
    private List<Coffee> list;

    public ControlledList() {
        this.list = new ArrayList<>();
    }

    public void add(Coffee coffee) {
        if (coffee.getPrice() < 1000) {
            throw new IllegalArgumentException("메뉴는 최소 1000원 이상이어야 합니다.");
        }
        list.add(coffee);
    }

    public List<Coffee> getList() {
        return Collections.unmodifiableList(list); // 불변 리스트 반환
    }

    @Override
    public String toString() {
        return "ControlledList{" +
                "list=" + list +
                '}';
    }
}
