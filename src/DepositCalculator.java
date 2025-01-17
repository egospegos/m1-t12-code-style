import java.util.Scanner;

public class DepositCalculator {
    double calculateCapitalizationDeposit(double amount, double yearRate, int period) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(income, 2);
    }

    double calculateSimpleDeposit(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void run() {
        int period, action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double result = 0;
        if (action == 1) {
            result = calculateSimpleDeposit(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateCapitalizationDeposit(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().run();
    }
}
