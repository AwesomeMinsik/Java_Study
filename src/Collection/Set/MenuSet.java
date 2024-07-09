package Collection.Set;
import Collection.Coffee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class MenuSet extends HashSet<Coffee>{
    private Set<Coffee> set;

    public MenuSet() {
        this.set =new HashSet<>();
    }

    public void addCoffee(Coffee coffee) {
        set.add(coffee);
    }

    public void printMenu() {
        for (Coffee coffee : set) {
            System.out.println(coffee);
        }
    }

    public int getMenuSize() {
        return set.size();
    }

    public void removeCoffee(Coffee coffee) {
        set.remove(coffee);
    }

    public boolean isMenuEmpty() {
        return set.isEmpty();
    }
    public Stream<Coffee> stream() {
        return set.stream();
    }

    @Override
    public Iterator<Coffee> iterator() {
        return set.iterator();
    }
    @Override
    public String toString() {
        return "MenuSet{" +
                "set=" + set +
                '}';
    }
}
