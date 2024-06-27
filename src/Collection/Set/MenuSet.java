package Collection.Set;
import Collection.Coffee;

import java.util.HashSet;
import java.util.Set;

public class MenuSet {
    private Set<Coffee> set;

    // 생성자: 외부에서 Set을 주입받는 방식


    public MenuSet() {
        this.set = new HashSet<>();
    }

    // Set에 새로운 Coffee 객체를 추가
    public void addCoffee(Coffee coffee) {
        set.add(coffee);
    }

    public void printMenu() {
        for (Coffee coffee : set) {
            System.out.println(coffee);
        }
    }

    // Set에 있는 Coffee 객체의 개수를 반환
    public int getMenuSize() {
        return set.size();
    }

    //Set에서 특정 Coffee 객체를 삭제
    public void removeCoffee(Coffee coffee) {
        set.remove(coffee);
    }

    //Set이 비어 있는지 확인하는 예시
    public boolean isMenuEmpty() {
        return set.isEmpty();
    }

}
