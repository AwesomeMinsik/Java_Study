package Collection.List;

import Collection.Coffee;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("아메리카노","맛있음",1500);
        Coffee coffee1 = new Coffee("아메리카노1","맛있음",2500);
        Coffee coffee2 = new Coffee("아메리카노2","맛있음",3500);

        List<Coffee> list = new ArrayList<Coffee>();
//        MenuList menuList = new MenuList(list);
        list.add(coffee);
        list.add(coffee1);
        list.add(coffee2);



        //데이터 순회방법

        //1. Enhanced for Loop
        for(Coffee item : list){
        System.out.println(item);
        }

        //2. Iterator
        Iterator<Coffee> iterator = list.iterator();
        while(iterator.hasNext()){
            Coffee item = iterator.next();
            System.out.println("Iterator:"+item);
        }

        //3. ListIterator (양방향 순회 제공)
        ListIterator<Coffee> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            Coffee item1 = listIterator.next();
            System.out.println("ListIterator:"+item1);
        }

        while (listIterator.hasPrevious()){
            Coffee item2 = listIterator.previous();
            System.out.println("ListIteratorPrevious:"+item2);
        }
        //4. forEach method
        list.forEach(item-> System.out.println(item));

        list.forEach(System.out::println); /* <- method reference */


        //5. stream API Java 8 (이상)

        list.forEach(System.out::println);
        Stream<Coffee> stream = list.stream().sorted();
        System.out.println("가격 오름차순 정렬");
        stream.forEach(System.out::println);


        //여기선 Coffee 타입의 객체에서 서로를비교할 수있는 기준이 없기 때문에 stream.sorted 로 정렬할 수없다.
        /* 이러한 문제를 해결하기 위해 Comparator 객체 또는  Comparable 인터페이스의 메서드를 정렬하려는 요소에 구현하여 사용할 수 있다.

            stream Api 에서 정렬기능을 제공하는 sorted 메서드는 요소의 정렬을 하기위해 Comparator 객체를 사용하거나
            객체가 없는 경우, 자동적으로 요소에 명시된 Comparable 인터페이스의 메서드 compareTo 를 사용한다.

            compareTo 메서드는 정렬 요소에 대한 기준을 제공하기 때문에 stream api와 comparable 인터페이스의 상호 협력을 정렬을 한다 볼 수있다.



            stream api에서 정렬기능을 제공하는 sorted 메서드는 정렬하기 위한 요소의 '정렬 기준'을 제공해 줘야 때문에
            이를 제공하는 Comparator 객체 또는
            정렬하려는 요소에 구현된 comparable 인터페이스의 메서드를 사용한다.

            Comparator 는 객체를 수정할 수 없는 경우 외부에서 객체의 정렬기준을 지정할 수있고, Comparable 인터페이스는 이를 구현한 객체 스스로가
            정렬기준을 제공할 수있게 한다. 따라서 상황에 맞게 객체 각자 역할에 적절한 수준으로 사용하여 정렬기준을 제시해야한다.

            이와 같이 stream().sorted() 메서드는
            정렬을 담당하는 Comparator 객체와 Comparable 인터페이스를 통해 정렬하려는 요소의 정렬 기준을 제공받아 값을 정렬한다.



         -Comparator 객체



         -Comparable인터페이스

            기본형 타입이 아닌 새로 정의된 타입의클래스에 구현하여 정렬기준을 정의 하거나
            Comparator를 직접 사용하여 정렬기준을 제공하여 사용할 수있다.

            public class Coffee implements Comparable<Coffee>{

                private String name;
                private String taste;
                private int price;

                public Coffee(String name, String taste, int price) {
                    this.name = name;
                    this.taste = taste;
                    this.price = price;
                }

                @Override
                public String toString() {
                    return "Coffee{" +
                            "name='" + name + '\'' +
                            ", taste='" + taste + '\'' +
                            ", price=" + price +
                            '}';
                }


                @Override
                public int compareTo(Coffee other) {
                    return Integer.compare(this.price, other.price);
                }

                public int getPrice() {
                    return price;
                }
            }

            */


//
//        System.out.println(stream);

        List<Coffee>list3 = new ArrayList<>() ;
        Map<Integer,Coffee> map=new HashMap<>();
        Set<Coffee> set = new HashSet<>();

    }
}
