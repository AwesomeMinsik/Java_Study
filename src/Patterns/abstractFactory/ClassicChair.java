package Patterns.abstractFactory;

public class ClassicChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("클래식 의자에 앉기.");
    }
}
