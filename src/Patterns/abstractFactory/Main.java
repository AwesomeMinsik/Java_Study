package Patterns.abstractFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory victorianFactory = new ClassicFurnitureFactory();

        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();

        modernChair.sitOn();  // 출력: Sitting on a modern chair.
        modernTable.eatOn();  // 출력: Eating on a modern table.
        victorianChair.sitOn();  // 출력: Sitting on a Victorian chair.
        victorianTable.eatOn();  // 출력: Eating on a Victorian table.
    }
}