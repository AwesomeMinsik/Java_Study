### 배열내부 데이터 정렬하기


최근에 스터디 목적으로 만들었던 카페 프로그램의
커피 메뉴를 관리할 객체를 설계하던중 정렬에 대한 문제가 있었다.
```java
public class Coffee{

    private String name;
    private String taste;
    private int price;

    public Coffee(String name, String taste, int price) {
        this.name = name;
        this.taste = taste;
        this.price = price;
    }

    //..생략
}
```
커피목록을 관리하는 list를 생성해
사용자가 요청하는 목록을 제공하기 위해 
Collection이 제공하는 sort 메서드로 정렬을 하려 했지만,
```java
        List<Coffee> list = new ArrayList<Coffee>();
//        MenuList menuList = new MenuList(list);
        list.add(coffee);
        list.add(coffee1);
        list.add(coffee2);
```


객체 내부적으로 정렬할 수있는 기준을 제공하지 않기 때문에
이를 제공하는 기능에 대해 알아보게 되었다.

### Comparable 인터페이스 와 Comparator 객체

객체의 정렬 기준을 배열 정렬에 사용할때 사용하는 메서드에게 제공하는 방법은
대표적으로 자바 표준라이브러리에서 제공하는Comparator 클래스와
Comparable 인터페이스를 사용하는 것이다.

Stream api에서 제공하는 정렬 메서드 sorted 또는 컬렉션 프레임워크의
sort 기능은 객체의 정렬 기준을 내부적으로나 외부적으로 제공해줘야 정렬을 할 수있기 때문에

자바에서 정렬 기준을 제공하는 클래스와 인터페이스를 사용해 역할을 수행한다.

Comparator 클래스는 객체를 수정할 수 없는 경우 외부에서 객체의 정렬기준을 정할 수있고,
Comparable 인터페이스는 이를 구현한 객체 스스로가 정렬기준을 제공할 수있게 한다.

따라서 상황에 맞게 객체 각자 역할에 적절한 수준으로 사용하여 정렬기준을 제시해야한다.

    - Comparator 클래스
```java
public class Main {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("아메리카노", 1500));
        coffees.add(new Coffee("카페라떼", 2500));
        coffees.add(new Coffee("에스프레소", 1800));


        Comparator<Coffee> priceComparator = new Comparator<Coffee>() {
            @Override
            public int compare(Coffee o1, Coffee o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        };
        
        Collections.sort(coffees, priceComparator);
        
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
```
정렬기준을 요소의 내부에서 제공해야 할땐 comparable 인터페이스의 정렬 메서드를
객체 내부에 구현하여 정렬할 수있다.



    - Comparable인터페이스
```java
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
                public int compareTo(Coffee other) {
                    return Integer.compare(this.price, other.price);
                }

                @Override
                public String toString() {
                    return "Coffee{" +
                            "name='" + name + '\'' +
                            ", taste='" + taste + '\'' +
                            ", price=" + price +
                            '}';
                }
                
                public int getPrice() {
                    return price;
                }
            }
```

Collection 프레임워크에서 제공하는 sort 이외에도
Stream api의 정렬 메서드를 사용하여 좀더 간결해진 코드로 정렬할 수있다.
    
    Stream은 Java 8 이상 버전부터 지원하는 API로,
    컬렉션과 배열의 연산에 대한 다양한 메서드를 제공하여
    데이터 연산을 간결하게 하기 위해 도입되었다.

메서드중 정렬기능을 제공하는 `sorted()` 메서드를 통해
arrayList에 담긴 Coffee타입 객체를 

가격 기준으로 정렬해보자.


```java
public class Main {
    public static void main(String[] args) {
        
        Coffee coffee = new Coffee("아메리카노", "고소하다", 1500);
        Coffee coffee1 = new Coffee("딸기라떼", "달다", 2500);
        Coffee coffee2 = new Coffee("에스프레소", "쓰다", 3500);

        List<Coffee> list = new ArrayList<Coffee>();
        list.forEach(System.out::println);

        Stream<Coffee> stream = list.stream().sorted();
        stream.forEach(System.out::println);
    }
}

```

    Stream Api를 사용한 방법 또한
    Coffee 타입의 객체에서 서로를비교할 수있는 기준이 없다면,
    Coffee를 stream().sorted() 메서드를 통해 정렬할 수없다.


stream api에서 정렬기능을 제공하는 sorted 메서드는 
정렬하기 위한 요소의 '정렬 기준'을 제공해 줘야 때문에
    
이를 제공하는 Comparator 객체 또는
정렬하려는 요소에 구현된 comparable 인터페이스의 메서드를 사용한다.

```java
public class Main {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("아메리카노", 1500));
        coffees.add(new Coffee("카페라떼", 2500));
        coffees.add(new Coffee("에스프레소", 1800));
        
        Comparator<Coffee> priceComparator = Comparator.comparingInt(Coffee::getPrice);
        
        Stream<Coffee> sortedCoffeeStream = coffees.stream()
                .sorted(priceComparator);

        sortedCoffeeStream.forEach(System.out::println);
    }
}
```

데이터의 정렬 역할을 수행하는 Collection 의 sort, stream 의 sorted
두 메서드 모두 Comparator클래스 또는 Comparable 인터페이스가 제공하는

객체의 정렬 기준이 역할 수행에 필요한 정보이다.

그저 편리한 기능이라 생각하고 지나칠 수도 있지만.
단순한 객체의 정렬기능 수행에도 Comparator, Comparable 인터페이스와
컬렉션 프레임워크 사이의 협력을 파악할 수있다.