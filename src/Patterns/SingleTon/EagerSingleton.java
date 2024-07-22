package Patterns.SingleTon;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("hi");
    }
}