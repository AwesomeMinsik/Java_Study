package Collection.Set.Lottery;

import java.util.*;

public class Lotto {


    //로또 숫자 중복제거로 LinkedHashSet 사용할 수 있을 거같음.

    private final LinkedHashSet<Integer> lottoNumbers;
    public final LinkedHashSet<Integer> winningNumbers;

    private final double minValue = 1;
    private final double maxValue = 45;

    public Lotto() {
        this.winningNumbers =  new LinkedHashSet<Integer>(6);
        this.lottoNumbers = new LinkedHashSet<Integer>(6);
    }

    private LinkedHashSet<Integer> generateNumbers() {
    LinkedHashSet<Integer> numbers = new LinkedHashSet<>(6);
    while (numbers.size() < 6) {
        int number = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        numbers.add(number);
    }
    return numbers;
    }

    public List<LinkedHashSet<Integer>> autoLottery(int quantityOfLottery) {
        List<LinkedHashSet<Integer>> lottoList = new ArrayList<>(quantityOfLottery);
        for (int i = 0; i < quantityOfLottery; i++) {
            LinkedHashSet<Integer> numbers = generateNumbers();
            lottoList.add(numbers);
        }
        return lottoList;
    }

    public LinkedHashSet<Integer> getWinningNumbers() {
        winningNumbers.clear();
        winningNumbers.addAll(generateNumbers());
        return winningNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}