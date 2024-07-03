package Collection.Set;

import Collection.Coffee;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


    Coffee coffee= new Coffee("아메리카노","맛있음",1500);
    Coffee coffee1= new Coffee("라떼","맛있음",2500);
    Coffee coffee2= new Coffee("카푸치노","맛있음",3500);

    MenuSet set = new MenuSet();

    set.addCoffee(coffee);
    set.addCoffee(coffee1);
    set.addCoffee(coffee2);

    set.forEach(System.out::println);

    Stream<Coffee> stream = set.stream().sorted();

    stream.forEach(System.out::println);

    }

}
