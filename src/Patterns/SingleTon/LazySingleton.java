package Patterns.SingleTon;

public class LazySingleton {
    // 인스턴스를 정적 필드로 선언 (초기화는 하지 않음)
    private static LazySingleton instance;

    // 생성자를 private으로 선언하여 외부에서 인스턴스화 할 수 없도록 함
    private LazySingleton() {}

    // 인스턴스를 반환하는 정적 메소드, 필요한 시점에 인스턴스를 생성
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // 예제 메소드
    public void showMessage() {
        System.out.println("hi");
    }
}