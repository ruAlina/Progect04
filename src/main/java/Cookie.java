import java.math.BigDecimal;

public class Cookie extends Sweets {

    private boolean includesGluten;

    public Cookie(String name, BigDecimal price, int weight, boolean includesGluten) {
        super(name, price, weight);
        this.includesGluten = includesGluten;
    }

    @Override
    public void printInfo() {
        System.out.println("Печенье  " + getName() + ", цена: " + getPrice() + ", вес: " + getWeight() + ", " + (includesGluten ? "" : "не ") + "содержит глютен.");
    }

    public boolean isIncludesGluten() {
        return includesGluten;
    }

    public void setIncludesGluten(boolean includesGluten) {
        this.includesGluten = includesGluten;
    }
}
