### Stream Api로 배열내부 데이터 정렬하기

Stream은 Java 8 이상 버전부터 지원하는 API로, 

컬렉션과 배열의 연산에 대한 다양한 메서드를 제공하여 

데이터 연산을 간결하게 하기 위해 도입되었다.

메서드중 정렬기능을 제공하는 `sorted()` 메서드를 통해
arrayList에 담긴 Coffee타입 객체를 

가격 기준으로 정렬해보자.

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

    여기선 Coffee 타입의 객체에서 서로를비교할 수있는 기준이 없기 때문에
    Coffee를 stream().sorted() 메서드를 통해 정렬할 수없다.


stream api에서 정렬기능을 제공하는 sorted 메서드는 
정렬하기 위한 요소의 '정렬 기준'을 제공해 줘야 때문에
    
이를 제공하는 Comparator 객체 또는
정렬하려는 요소에 구현된 comparable 인터페이스의 메서드를 사용한다.

Comparator 는 객체를 수정할 수 없는 경우 외부에서 객체의 정렬기준을 지정할 수있고, 
Comparable 인터페이스는 이를 구현한 객체 스스로가 정렬기준을 제공할 수있게 한다.

    따라서 상황에 맞게 객체 각자 역할에 적절한 수준으로 사용하여 정렬기준을 제시해야한다.

[//]: # (    )
    -Comparable인터페이스

        기본형 타입이 아닌 새로 정의된 타입의클래스에 구현하여 정렬기준을 정의 하거나
        Comparator를 직접 사용하여 정렬기준을 제공하여 사용할 수있다.

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