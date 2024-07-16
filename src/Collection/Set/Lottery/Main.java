package Collection.Set.Lottery;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        Lotto lotto = new Lotto();
        LotteryCommittee lotteryCommittee = new LotteryCommittee();
//        lotto.getWinningNumbers();
//        lotto.autoLottery();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        System.out.println(lotto.getWinningNumbers());
        lotteryCommittee.calculationLotteryList(lotto.autoLottery(userInput));
    }
}
