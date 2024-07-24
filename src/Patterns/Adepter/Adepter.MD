### 어댑터 패턴 (Adapter Pattern)

어댑터 패턴은 기존의 클래스를 변경하지 않고도 호환되지 않는 인터페이스를 사용할 수 있게 해주는 디자인 패턴이다.

### 목적
서로 다른 인터페이스를 가진 클래스들을 함께 사용할 수 있도록 하는 것이다.

### 구조
Target (목표 인터페이스)

클라이언트가 사용하려고 하는 인터페이스를 정의한다.
Client (클라이언트)

Target 인터페이스를 사용하여 작업을 수행한다.
Adaptee (적응 대상)

기존 클래스, 호환되지 않는 인터페이스를 가지고 있다.
Adapter (어댑터)

Adaptee의 인터페이스를 Target의 인터페이스로 변환한다.


어뎁터 패턴 예제

```java
public interface Shape {
    void draw();
}

```

```java

public class Rectangle {
    public void drawRectangle() {
        System.out.println("Drawing a rectangle");
    }
}

```

```java

public class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.drawRectangle();
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        Shape rectAdapter = new RectangleAdapter(rectangle);

        rectAdapter.draw();  // Outputs "Drawing a rectangle"
    }
}
```

예제에서는 Shape 인터페이스와 Rectangle 클래스가
호환되지 않는 인터페이스를 가지고 있지만, 

어댑터 패턴을 통해 Rectangle 클래스의 기능을 
Shape 인터페이스로 변환하여 사용할 수 있다.