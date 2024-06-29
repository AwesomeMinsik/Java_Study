package Collection.List;

import Collection.Coffee;
import jdk.jfr.TransitionFrom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuList {


    public List<Coffee> List = new ArrayList<>();

    public MenuList(List<Coffee> list) {
        List = list;
    }

//    @Override
//    public String toString() {
//        return "MenuList{" +
//                "List=" + List +
//                '}';
//    }
    public void add(Coffee coffee){
        List.add(coffee);
    }

}
