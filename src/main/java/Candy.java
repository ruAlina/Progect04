import java.math.BigDecimal;

public class Candy extends Sweets {

    private CandyType candyType;

    public Candy(String name, BigDecimal price, int weight, CandyType candyType) {
        super(name, price, weight);
        this.candyType = candyType;
    }

    @Override
    public void printInfo() {
        System.out.println(candyType.getHumanText() + " " + getName() + ", цена: " + getPrice() + ", вес: " + getWeight() + ".");
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }
}
