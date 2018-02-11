import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Gift {

    private BigDecimal totalPrice = new BigDecimal(0);

    private int totalWeight = 0;

    private List<Sweets> sweets = new ArrayList<>();

    public void addSweets(Sweets item) {
        sweets.add(item);
        totalPrice = totalPrice.add(item.getPrice());
        totalWeight += item.getWeight();
    }

    public void printInfo() {
        System.out.println("Суммарный вес подарка: " + totalWeight + "г");
        System.out.println("Суммарная стоимость подарка: " + totalPrice.toPlainString());
        System.out.println("Содержимое подарка:");
        for (Sweets sweet : sweets) {
            sweet.printInfo();
        }
    }
}
