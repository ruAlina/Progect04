import java.math.BigDecimal;

public class Chocolate extends Sweets {

    private int cacaoPercent;

    public Chocolate(String name, BigDecimal price, int weight, int cacaoPercent) {
        super(name, price, weight);
        this.cacaoPercent = cacaoPercent;
    }

    public void printInfo() {
        System.out.println((cacaoPercent < 20 ? "Белый" :(cacaoPercent > 40 ? "Горький" : "Молочный")) + " шоколад " + getName() + ", цена: " + getPrice() + ", вес: " + getWeight() + ".");
    }

    public int getCacaoPercent() {
        return cacaoPercent;
    }

    public void setCacaoPercent(int cacaoPercent) {
        this.cacaoPercent = cacaoPercent;
    }
}
