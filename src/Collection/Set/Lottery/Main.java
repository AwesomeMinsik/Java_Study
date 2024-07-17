package Collection.Set.Lottery;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Lotto lotto = new Lotto();
        LotteryCommittee lotteryCommittee = new LotteryCommittee();

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        System.out.println(lotto.getWinningNumbers());
        lotteryCommittee.calculationLotteryList(lotto.autoLottery(userInput));
    }
}
