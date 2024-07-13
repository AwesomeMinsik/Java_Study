package Collection.Set.Lottery;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {


    //로또 숫자 중복제거로 LinkedHashSet 사용할 수 있을 거같음.
    private int[] lottoNumbers;
    private final double minValue =1;
    private final double maxValue =45;
    public Lotto(){
        this.lottoNumbers = new int[6];
    }


    public int[] autoLottery(){
        for(int i = 0 ; i <6 ; i++){
            this.lottoNumbers[i]= (int) (Math.random() * (maxValue - minValue));
        }
        return lottoNumbers;
    }

    public int[] userInput(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i <6 ; i++){
            this.lottoNumbers[i]=scanner.nextInt();
        }
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + Arrays.toString(lottoNumbers) +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
