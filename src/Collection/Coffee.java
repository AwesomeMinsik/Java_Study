package Collection;

public class Coffee {

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
}
