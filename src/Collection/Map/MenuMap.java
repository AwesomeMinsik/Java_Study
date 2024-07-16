package Collection.Map;

import Collection.Coffee;

import java.util.HashMap;
import java.util.Map;

public class MenuMap {
    private Map<Integer, Coffee> map;

//    public MenuMap(Map<Integer, Coffee> map) {
//        this.map = new HashMap<>();
//    }

    /*map의 생성을 외부에서 주입받아생성하면 map의 여러 종류를 동적으로 사용할 수있다. 내부에서 정해진 자료구조만 사용해야하는 것이 아니면
    주입받아 사용하자 **map이라는 특정 Map 구현체에 종속되는것을 피할수있다.** */


    public MenuMap(Map<Integer, Coffee> map) {
        this.map = map;
    }

    public void setMap(Integer I,Coffee coffee){
        map.put(I,coffee);
    }

    @Override
    public String toString() {
        return "MenuMap{" +
                "map=" + map +
                '}';
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
}
