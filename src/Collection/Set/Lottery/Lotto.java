package Collection.Set.Lottery;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {


    //로또 숫자 중복제거로 LinkedHashSet 사용할 수 있을 거같음.

    private final LinkedHashSet<Integer> lottoNumbers;
    private final double minValue = 1;
    private final double maxValue = 45;

    public Lotto() {
        this.lottoNumbers = new LinkedHashSet<Integer>(6);
    }


    //    public int[] autoLottery(){
//        for(int i = 0 ; i <6 ; i++){
//            this.lottoNumbers[i]= (int) (Math.random() * (maxValue - minValue));
//        }
//        return lottoNumbers;
//    }
//
//    public int[] userInput(){
//        Scanner scanner = new Scanner(System.in);
//        for(int i = 0 ; i <6 ; i++){
//            this.lottoNumbers[i]=scanner.nextInt();
//        }
//        return lottoNumbers;
//    }
//
//    @Override
//    public String toString() {
//        return "Lotto{" +
//                "lottoNumbers=" + Arrays.toString(lottoNumbers) +
//                ", minValue=" + minValue +
//                ", maxValue=" + maxValue +
//                '}';
//    }
//}
    public LinkedHashSet<Integer> autoLottery() {
        lottoNumbers.clear();
        while (lottoNumbers.size() < 6) {
            int number = (int) (Math.random() * (maxValue - minValue) + minValue);
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    public LinkedHashSet<Integer> userInput() {
        Scanner scanner = new Scanner(System.in);
        lottoNumbers.clear();
        while (lottoNumbers.size() < 6) {
            System.out.println("Enter a number between " + minValue + " and " + maxValue + ": ");
            int number = scanner.nextInt();
            if (number >= minValue && number <= maxValue) {
                lottoNumbers.add(number);
            } else {
                System.out.println("Number out of range. Please try again.");
            }
        }
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}