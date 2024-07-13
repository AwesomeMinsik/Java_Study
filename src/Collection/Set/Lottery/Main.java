package Collection.Set.Lottery;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Lotto lotto = new Lotto();
        int[] userLotto1 = lotto.autoLottery();
        System.out.println(Arrays.toString(userLotto1));
        int[] userLotto2 = lotto.userInput();
        System.out.println(Arrays.toString(userLotto2));

    }
}
