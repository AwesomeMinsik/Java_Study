package Collection.Set.Lottery;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

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
    public LinkedHashSet<Integer> autoLottery() {
        lottoNumbers.clear();
        while (lottoNumbers.size() < 6) {
            int number = (int) (Math.random() * (maxValue - minValue) + minValue);
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    public LinkedHashSet<Integer> getWinningNumbers(){
        winningNumbers.clear();
        while (winningNumbers.size() < 6) {
            int number = (int) (Math.random() * (maxValue - minValue) + minValue);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }


//    public LinkedHashSet<Integer> userInput() {
//        Scanner scanner = new Scanner(System.in);
//        lottoNumbers.clear();
//        while (lottoNumbers.size() < 6) {
//            System.out.println("숫자를 입력해주세요" + minValue + " ~ " + maxValue);
//            int number = scanner.nextInt();
//            if (number >= minValue && number <= maxValue) {
//                lottoNumbers.add(number);
//            } else {
//                System.out.println("입력값이 범위를 초과헀습니다.");
//            }
//        }
//        return lottoNumbers;
//    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}