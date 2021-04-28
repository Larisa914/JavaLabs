package com.company.dla.lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // В О П Р О С Ы
        // 1. Почему userInput = scanner.nextLine(); в некоторых ситуациях считывает пустой символ
        // 2. После эксепшена операция userInput = scanner.next(); также считаывает пустой символ
        //
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            try {
                System.out.println("Введите действие [+ - * / ! q]:");
                String userInput = scanner.next();

                if ("q".equals(userInput)) {
                    throw new ExitException();
                }

                System.out.println("Введите числа:");
                int firstNumber = scanner.nextInt();

                int secondNumber = "!".equals(userInput) ? 0 : scanner.nextInt();

                double result;
                switch (userInput) {
                    case "+":
                        result = plus(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = minus(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = ymn(firstNumber, secondNumber);
                        break;
                    case "/":
                        result = del(firstNumber, secondNumber);
                        break;
                    case "!":
                        result = factorial(firstNumber);
                        break;
                    default:
                        System.out.println("Некорректная операция!");
                        result = 0;
                        break;
                }
                System.out.println(result);

            } catch (InputMismatchException ex) {
                System.out.println("Не число! Повторите ввод данных!");
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Деление на ноль запрещено!");
            } catch (ExitException ex) {
                isExit = true;
            }
        }
    }

    private static int plus(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    private static int minus(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private static int ymn(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    private static int del(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }

    private static int factorial(int numberOne) {
        int res = 1;
        for (int i = 1; i <= numberOne; i++) {
            res *= i;
        }
        return res;
    }

    private static class ExitException extends Exception {
    }
}
