package Patterns.abstractFactory;

public class ClassicTable implements Table{

    @Override
    public void eatOn() {
        System.out.println("클래식 테이블에서 먹기.");
    }
}
