import java.util.Arrays;
import java.util.stream.Collectors;

public enum CandyType {
    CARAMEL(1), TOFFEE(2), MARZIPAN(3), PRALINE(4), GRILLING(5);

    private int code;

    private CandyType(int code) {
        this.code = code;
    }

    public static CandyType byCode(int code) {
        switch (code) {
            case 1:
                return CARAMEL;
            case 2:
                return TOFFEE;
            case 3:
                return MARZIPAN;
            case 4:
                return PRALINE;
            case 5:
                return GRILLING;
        }

        throw new IllegalArgumentException();
    }

    public String getHumanText() {
        switch (this) {
            case CARAMEL:
                return "Карамель";
            case TOFFEE:
                return "Ирис";
            case MARZIPAN:
                return "Марципан";
            case PRALINE:
                return "Пралине";
            case GRILLING:
                return "Грильяж";
        }

        return null;
    }

    public static int getMaxCode() {
        return 5;
    }

    public static int getMinCode() {
        return 1;
    }

    public static String prompt() {
        return String.join(", ", Arrays.asList(CandyType.values()).stream().map((value) -> value.getHumanText() + "(" + value.getCode() + ")").collect(Collectors.toList()));
    }

    public int getCode() {
        return code;
    }
}
