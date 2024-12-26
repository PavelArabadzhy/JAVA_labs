package org.example;

import java.util.Scanner;
//test
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введіть перше число:");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.println("Введіть друге число:");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Оберіть операцію (+, -, *, /, sqrt):");
            String operation = scanner.nextLine();

            double result;
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "sqrt":
                    System.out.println("Оберіть число (1 або 2):");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        result = calculator.sqrt(num1);
                    } else {
                        result = calculator.sqrt(num2);
                    }
                    System.out.println("Результат: " + result);
                    break;
                default:
                    System.out.println("Невірна операція!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено некоректне число.");
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
        scanner.close();
    }
}