자료구조의 데이터를 순회하고 연산하는 간단한 코드 작성중에
제어할 데이터의 제약조건추가 및 요소의 연산,제어를
클라이언트 코드에서 진행하는 것이 책임 할당 부분에서 부적절하고 가독성도 떨어져 보여 고민하던중에



컬렉션을 래핑하여 제어할 수 있는 일급컬렉션에 대해 알게되어
기존 컬렉션을 사용했을때 필요한 메서드를 상속받고 검증할 수있는 형태로 구현해 보았다.

일급컬렉션(컬렉션 래핑 클래스)
일급 컬렉션(First Class Collection)은

기존의 컬렉션을 직접 쓰는 방식의 데이터의 외부 접근 문제와, 비즈니스 로직의 분산등의 문제를

해결하기위해 고안된 디자인 패턴 이다.





일급컬렉션을 사용할때 지켜야 할 것은 다음과같다.

    컬렉션 외의 다른 멤버 변수를 가지지 않는다
일급 컬렉션은 하나의 컬렉션 외에 다른 멤버 변수를 가지지 않는 것이 원칙이다. \
이는 컬렉션에 대한 책임을 명확히 하기 위함이다.

    비즈니스 로직을 포함한다
컬렉션에 관련된 비즈니스 로직은 일급 컬렉션 내부에 포함하여 응집도를 높이고,\
컬렉션을 사용하는 코드의 가독성을 향상시킨다.

    컬렉션의 상태 변경을 내부에서만 허용
컬렉션의 요소 추가, 제거 등의 상태 변경 작업은 일급 컬렉션 내부에서만 허용하고,\
외부에서는 이를 직접 수행하지 못하도록 제한한다.

    컬렉션의 불변성을 유지할 수 있도록 노력
가능한 경우, 컬렉션을 불변으로 만들어 데이터의 불변성을 유지한다.\
불변 컬렉션을 사용하면 동시성 문제를 피하고, 코드의 예측 가능성을 높일 수 있다.





public class ControlledList {
private List<Coffee> list;

    public ControlledList() {
        this.list = new ArrayList<>();
    }

    public void add(Coffee coffeeList){
        list.add(coffeeList);
    }

    public List<Coffee> getList(){
        return list;
    }

    @Override
    public String toString() {
        return "ControlledList{" +
                "list=" + list +
                '}';
    }
}


일급컬렉션의 형태를 갖추긴 했지만, 여기에서 컬렉션을 직접 사용하는 것과 별 다를 장점이 보이진 않는다.
컬렉션이 기본으로 가진 메서드랑 기능이 별 차이도 없고, 추가적인 메서드 호출로 자원소모만 늘어날 뿐이다.

```java
public class Main {
public static void main(String[] args) {

        Coffee americano = new Coffee("아메리카노","맛있다",5000);
        Coffee latte = new Coffee("라떼","맛있다!",8000);


        //일급컬렉션
        ControlledList controlledList= new ControlledList();

        controlledList.add(americano);
        controlledList.add(latte);
        System.out.println(controlledList.getList());

        //컬렉션 직접사용
        List<Coffee> coffeeList = new ArrayList<>();

        coffeeList.add(americano);
        coffeeList.add(latte);

        System.out.println(coffeeList);

    }
}
```


제약조건을 통해 데이터의 무결성을 유지해야 하는 부분은 일급컬렉션을 사용하면 검증 로직의 분산과

책임 할당문제를 해결할 수있다. 이는 일급컬렉션이 가지고있는 도메인 개념의 장점이며



이는 일급컬렉션 객체가 도메인 개념을 담고 있음을 암시하며, 책임이 분산되지 않기 때문에

객체지향 프로그래밍의 이점을 활용할 수 있다.

```java
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

    //.. 생략

}

```



데이터의 일관성유지를 위해 불변컬렉션을 사용할 수있다.

이는 외부로부터의 조작을 막아 데이터의 정확도와 신뢰성을 향상시킨다.



기존 List 를 반환하는 메서드의 반환값은 List 자체를 반환해 값을 조작할 수있는 여지를 남긴다.

데이터의 일관성을 유지해야하는 요소들은 값을 불러올때 조작할 수없는 값을 반환하는
컬렉션의 unmodifiableList() 메서드를 활용하자.
```java
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

    //불변 컬렉션 메서드
    public List<Coffee> getList() {
        return Collections.unmodifiableList(list); 
    }

    //..생략
}

```

또한 일급컬렉션에서 사용하는 비즈니스 로직은 언제든 동일한 기능을 필요로하는 다른 곳에서 사용할 수있기 때문에,
재사용성 측면에서도 코드중복을 줄여 생산성 향상에 도움이된다.



단점이라고 하면 일급컬렉션은 컬렉션 요소에 대한 연산,제어 메서드를 상황에 따라
전부 구현해야하는 소요가 생길 수 있고,



기존 컬렉션의 메서드 이외에 추가적인 메서드호출로 메모리 성능
오버헤드가 발생할 수 있다고 한다.



하지만 이는 데이터 무결성과, 메서드의 응집도, 비즈니스 로직 확장성 등을 따졌을때
일급컬렉션 사용으로 발생하는 성능저하에 대한 문제는 무시할 만한 수준이라 한다.