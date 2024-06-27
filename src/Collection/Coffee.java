package Collection;

public class Coffee implements Comparable<Coffee>{

    private String name;
    private String taste;
    private int price;

    public Coffee(String name, String taste, int price) {
        this.name = name;
        this.taste = taste;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }



//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
    @Override
    public int compareTo(Coffee other) {
        // price를 기준으로 정렬
        return Integer.compare(this.price, other.price);
    }

}
