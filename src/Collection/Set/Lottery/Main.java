package Collection.Set.Lottery;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Lotto lotto = new Lotto();
        LinkedHashSet<Integer> userLotto1 = lotto.autoLottery();
        System.out.println(userLotto1);
        Set<Integer> userLotto2 = lotto.userInput();
        System.out.println(userLotto2);

    }
}
