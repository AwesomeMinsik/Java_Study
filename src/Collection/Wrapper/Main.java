package Collection.Wrapper;

import Collection.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("아메리카노","맛있다",5000);
        Coffee coffee2 = new Coffee("라떼","맛있다!",8000);

        ControlledList controlledList= new ControlledList();

        controlledList.add(coffee1);
        List<Coffee> list = controlledList.getList();

        System.out.println(list);
        System.out.println(controlledList.getList());
//=================================

        List<Coffee> coffeeList = new ArrayList<>();

        coffeeList.add(coffee1);
        coffeeList.add(coffee2);

        System.out.println(coffeeList);

    }
}
