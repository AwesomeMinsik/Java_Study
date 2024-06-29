### 자바 Collection


    Collection 은 데이터의 형태나 목적에 따라 
    다양한 방법의 연산을 사용하여 
    
    데이터의 저장,연산을 할 수있는 기능을 제공하는
    인터페이스와 클래스들을 포함한 자바의 API 이다.

### Collection 인터페이스

Collection프레임워크 내부에는 컬렉션 루트 인터페이스와 이를 
상속하는 다양한 자료형식에 대해 연산및 저장을 할 수있는
List,Set,Queue 가 있다 

내부적으로는 이 세가지 인터페이스를 상속하는
arrayList,linkedList,vector,stack,hashSet,linkdeHashSet,TreeSet... 등등
데이터 처리방식이 다른 다양한 인터페이스가 있다.


```java
public interface List<E> extends SequencedCollection<E> {
    // Query Operations
    
    //..생략
}

public interface Set<E> extends Collection<E> {
    // Query Operations
    
    //..생략
}

public interface Map<K, V> {
    // Query Operations

    //..생략
}
```
    필자는 Map또한 Collection에 속하기 때문에 Collection 루트인터페이스를 상속하는
    자료구조 인터페이스로 알고 있었지만, 내부 소스코드를 확인해보니
    
    Map 은 List 와 Set 처럼 단일 값이 아닌 Key-Value 쌍을 저장는 별도의 데이터 구조이기 때문에
    컬렉션 인터페이스를 상속하지않지만 컬렉션 프레임워크의 일부인 자료구조임을 알 수있었다.

컬렉션 프레임워크의 자료구조들은 각각의 데이터를 연산및 저장하기위한
메서드를 가지고있으며

이를 통해 배열에 데이터를 저장하거나 연산하기위한
길고 복잡한 반복문과 연산자들을 사용하지않고 단순화 하여 처리할 수있다.

### 컬렉션 프레임워크 장점

자료구조 인터페이스의 집합인 컬렉션 프레임워크는 데이터를 좀더
다양한 방식으로 관리하여 기존에 데이터를 일괄 처리할때 사용하던 배열보다
용도에따라 좀더 편리하고 성능또한 우월하다.


따라서 용도에 따라 적절한 자료구조로 데이터를 처리하면
기존 배열로 처리하던 여러 데이터를 빠르고 의도에 맞게 사용할 수있는 것이
컬렉션 프레임워크의 장점이라 할 수 있다.