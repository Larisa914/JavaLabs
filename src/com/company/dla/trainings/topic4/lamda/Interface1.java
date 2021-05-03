package com.company.dla.trainings.topic4.lamda;

public class Interface1 {

    @FunctionalInterface
    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula1.calculate(100));     // 100.0
        System.out.println(formula1.calculate(50));     // 100.0
        formula1.sqrt(-23);          // 0.0
        Formula.positive(-4);        // 0.0

        Formula formula2 = a -> Math.sqrt(Formula.positive(a) * 100.0);

        System.out.println(formula2.calculate(100));
        System.out.println(formula2.calculate(50));

        final int someVariable = 7;

        Formula formula3 = a -> a * (a + 10) + someVariable;
        System.out.println(formula3.calculate(100));
        System.out.println(formula3.calculate(50));

        Formula formula4 = a -> {
            double temp = someVariable / 100.0 * someVariable / 2.0;
            return a * (a + 10) + someVariable + temp;
        };
        System.out.println(formula4.calculate(100));
        System.out.println(formula4.calculate(50));
    }

}
