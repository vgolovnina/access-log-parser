import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите первое число: ");
        int firstNumber = new Scanner(System.in).nextInt();

        System.out.println("Введите второе число: ");
        int secondNumber = new Scanner(System.in).nextInt();

        int summ = firstNumber + secondNumber;
        int diff = firstNumber - secondNumber;
        int multi = firstNumber * secondNumber;
        double quotient = (double) firstNumber / secondNumber;

        System.out.println("Сумма " + summ);
        System.out.println("Разность " + diff);
        System.out.println("Произведение " + multi);
        System.out.println("Частное " + quotient);

    }
}