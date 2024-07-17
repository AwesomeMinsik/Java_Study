package Collection.Set.Lottery;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryCommittee {

    public final LinkedHashSet<Integer> winningNumbers;
    private final double minValue = 1;
    private final double maxValue = 45;

    public LotteryCommittee() {
        this.winningNumbers = new LinkedHashSet<Integer>(6);
    }
    public LinkedHashSet<Integer> getWinningNumbers(){
        winningNumbers.clear();
        while (winningNumbers.size() < 6) {
            int number = (int) (Math.random() * (maxValue - minValue) + minValue);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private void sortingLottoNumbers(){

    }

    public void calculationLotteryList(List<LinkedHashSet<Integer>> lottoList) {
        int i = 1;
        for (LinkedHashSet<Integer> ticket : lottoList) {
            System.out.println("Ticket " + i + ": " + new TreeSet<>(ticket));
            i++;
        }
    }

//    public List<TreeSet<Integer>> calculationLotteryList(List<LinkedHashSet<Integer>> lottoList) {
//        List<TreeSet<Integer>> sortedLottoList = new ArrayList<>();
//
//        for (LinkedHashSet<Integer> ticket : lottoList) {
//            sortedLottoList.add(new TreeSet<>(ticket));
//        }
//
//        return sortedLottoList;
//    }

}
