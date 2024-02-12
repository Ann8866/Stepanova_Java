package aston.stepanova.qa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Сравнение двух целых чисел
        System.out.println(compareDigits());

        System.out.println("______________________________");
        // Сравнение двух строк
        System.out.println(compareStrings());

        System.out.println("______________________________");
        // Поиск чётных чисел в массиве
        System.out.println(getEvenDigits());

        System.out.println("______________________________");
        // калькулятор двух чисел
        System.out.println(calculate());
    }

    private static String compareDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое целое число для сравнения");
        final var first = scanner.nextInt();
        System.out.println("Введите второе целое число для сравнения");
        final var second = scanner.nextInt();

        final var operator = first > second ? ">" : "<";
        return String.format("%s %s %s", first, operator, second);
    }

    private static String compareStrings() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку для сравнения");
        final var first = scanner.next();
        System.out.println("Введите вторую строку для сравнения");
        final var second = scanner.next();

        return first.equals(second) ? "строки идентичны" : "строки неидентичны";
    }

    private static List<Integer> getEvenDigits() {
        List<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Для поиска чётных чисел, введите любое количество цифр через запятую. Например 1, 2, 3");

        final var someDigits = scanner.nextLine();
        Arrays.stream(someDigits.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .filter(number -> number % 2 == 0)
                .forEach(result::add);

        return result;
    }

    private static Double calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое целое число");
        final var first = scanner.nextInt();
        System.out.println("Введите математическую операцию (поддерживаются операции сложения + вычитания - деления / и умножения *)");
        final var operation = scanner.next();
        System.out.println("Введите второе целое число");
        final var second = scanner.nextInt();

        return calc(first, second, operation);
    }

    private static Double calc(double firstNumber, double secondNumber, String operation){
        double result;
        switch (operation){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculate();
        }
        return result;
    }
}
