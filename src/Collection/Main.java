package Collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Coffee coffee= new Coffee("아메리카노","맛있음",1500);
        Coffee coffee1= new Coffee("아메리카노1","맛있음",1500);
        Coffee coffee2= new Coffee("아메리카노2","맛있음",1500);
        List<Coffee> coffeeList = new ArrayList<>();

        //add() list에 객체 참조 삽입
        coffeeList.add(coffee);
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);

        System.out.println("커피목록:"+coffeeList);

        //.size list 사이즈반환
        System.out.println(coffeeList.size());
        //remove() list 의 참조 삭제
        coffeeList.remove(coffee);

        //add(index,object) 인덱스를 지정해 객체 추가함(이미 참조하는 객체가 있을경우 기존 인덱스의 객체가 뒤로 밀림) 시간복잡도 O(n) - 수행속도 선형적증가
        coffeeList.add(0,coffee2); //linkedList 자료구조에서 index = 0 의경우 firstadd 로 사용할 수 있음
        System.out.println("인덱스에 객체참조 추가:"+coffeeList);
    
        //get(int index) index 참조객체가져오기
        Coffee coffee3 = coffeeList.get(2);
        System.out.println(".get 으로 가져온 커피 = "+coffee3);

        System.out.println("커피목록:"+coffeeList);

        MenuList list = new MenuList(coffeeList);

        System.out.println(list);

        list.add(coffee);
        System.out.println(list);
// ===================================SET=======================================//
            /*set 은 저장할 값의 중복을 허용하지않는다.*/
        Set<Coffee>set = new HashSet<>();

        set.add(coffee);
        set.add(coffee1);
        set.add(coffee2);
        set.add(coffee2);
        //중복값입력 허용x
//        System.out.println(coffeeSet);
//        System.out.println("set:"+);
        System.out.println("set:"+set);
        //set 은 객체저장순서를 보장하지않음

        MenuSet coffeeSet= new MenuSet();
        coffeeSet.addCoffee(coffee);
        coffeeSet.addCoffee(coffee1);
        coffeeSet.addCoffee(coffee2);
        System.out.println(set);
        //[Coffee{name='아메리카노2'..생략}, Coffee{name='아메리카노',..생략}, Coffee{name='아메리카노1',..생략}]


//        ============================Map=============================//
        /*map 은 key-value 쌍을 저장하는 자료구조이며 key 의 중복을 허용하지않는다.
            key는 하나의 value만 제공함 동일한 key로 저장하면 마지막으로 저장한 값으로 대체됨*/
        Map<Integer,Coffee> map= new HashMap<>();
        map.put(1,coffee);
        map.put(1,coffee1);
        map.put(3,coffee2);
        System.out.println("map:"+map);
//      map:{1=Coffee{name='아메리카노1', taste='맛있음', price=1500}, 3=Coffee{name='아메리카노2', taste='맛있음', price=1500}}

        MenuMap CoffeeMap = new MenuMap(map);
        CoffeeMap.setMap(1,coffee);
        CoffeeMap.setMap(2,coffee1);
        CoffeeMap.setMap(2,coffee2);

        System.out.println("CoffeeMap:"+CoffeeMap);
        //CoffeeMap:MenuMap{map={1=Coffee{name='아메리카노'..생략}, 2=Coffee{name='아메리카노2'..생략}, 3=Coffee{name='아메리카노2..생략}}}

    }
}
