package Patterns.abstractFactory;

public class ModernTable implements Table{

    @Override
    public void eatOn() {
        System.out.println("모던 테이블에서 먹기.");
    }
}
