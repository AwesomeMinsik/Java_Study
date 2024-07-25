package Patterns.Factory;

public class ConcreteJudgeFactory extends JudgeFactory{
    @Override
    public Judge createJudge(String judgeName) {
        if (judgeName.equals("왕"))
            return new King();
        if (judgeName.equals("여왕"))
            return new Queen();
        else return null;
    }
}
