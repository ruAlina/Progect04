import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class Program {

    public static Scanner scanner = new Scanner(System.in);

    public static PrintStream out = System.out;

    public static void main(String[] args) {
        Gift gift = new Gift();
        Sweets sweets;
        while (null != (sweets = promptSweets())) {
            gift.addSweets(sweets);
        }

        gift.printInfo();
    }

    public static BigDecimal promptPrice() {
        while (true) {
            out.println("Введите цену упаковки:");

            String input = scanner.next();
            try {
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(input));
                if (price.signum() <= 0) {
                    out.println("Цена должна быть положительной");
                    continue;
                }
                return price.setScale(2, BigDecimal.ROUND_CEILING);
            } catch (NumberFormatException nfe) {
                out.println("Не удалось распознать число");
            }
        }
    }

    public static int promptWeight() {
        while (true) {
            System.out.println("Введите вес упаковки в граммах:");
            String input = scanner.next();
            try {
                int weight = Integer.parseInt(input);
                if (weight <= 0) {
                    out.println("Вес должен быть положительным");
                    continue;
                }
                return weight;
            } catch (NumberFormatException nfe) {
                out.println("Не удалось распознать число");
            }
        }
    }

    public static String promptName() {
        while (true) {
            System.out.println("Введите наименование:");
            String input = scanner.next();
            if (input == null || input.length() == 0) {
                out.println("Наименование не может быть пустым");
                continue;
            }
            return input;
        }
    }

    public static int promptCacaoPercent() {
        while (true) {
            System.out.println("Введите процент содержания какао:");
            String input = scanner.next();
            try {
                int cacaoPercent = Integer.parseInt(input);
                if (cacaoPercent < 0 || cacaoPercent > 100) {
                    out.println("Значение должно быть в пределах от 0 до 100");
                    continue;
                }
                return cacaoPercent;
            } catch (NumberFormatException nfe) {
                out.println("Не удалось распознать число");
            }
        }
    }

    public static CandyType promptCandyType() {
        while (true) {
            System.out.println("Введите числовой код требуемого типа конфет [" + CandyType.prompt() + "]:");
            String input = scanner.next();
            try {
                int candyCode = Integer.parseInt(input);
                if (candyCode < CandyType.getMinCode() || candyCode > CandyType.getMaxCode()) {
                    out.println("Значение должно быть в пределах от " + CandyType.getMinCode() + " до " + CandyType.getMaxCode());
                    continue;
                }
                return CandyType.byCode(candyCode);
            } catch (NumberFormatException nfe) {
                out.println("Не удалось распознать число");
            }
        }
    }

    public static boolean promptContainsGluten() {
        while (true) {
            System.out.println("Содержит ли данное печенье глютен (д/н)?");
            String input = scanner.next();
            if ("д".equalsIgnoreCase(input)) {
                return true;
            } else if ("н".equalsIgnoreCase(input)) {
                return false;
            } else {
                out.println("Введите \"д\" - ДА или \"н\" - НЕТ");
                continue;
            }
        }
    }

    public static Sweets promptSweets() {
        int sweetsCode = 0;
        while (true) {
            System.out.println("Введите числовой код требуемого типа сладостей [Конфеты(1), Печенье(2), Шоколад(3)] или (0) чтобы закончить формирование подарка:");
            String input = scanner.next();
            try {
                sweetsCode = Integer.parseInt(input);
                if (sweetsCode < 0 || sweetsCode > 3) {
                    out.println("Значение должно быть в пределах от 0 до 3");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                out.println("Не удалось распознать число");
            }
        }

        if (sweetsCode == 0) {
            return null;
        }

        String name = promptName();
        BigDecimal price = promptPrice();
        int weight = promptWeight();

        if (sweetsCode == 1) {
            CandyType candyType = promptCandyType();
            return new Candy(name, price, weight, candyType);
        } else if (sweetsCode == 2) {
            boolean containsGluten = promptContainsGluten();
            return new Cookie(name, price, weight, containsGluten);
        } else if (sweetsCode == 3) {
            int cacaoPercent = promptCacaoPercent();
            return new Chocolate(name, price, weight, cacaoPercent);
        } else {
            return null;
        }
    }
}
