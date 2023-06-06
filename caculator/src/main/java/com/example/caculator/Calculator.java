package com.example.caculator;

public class Calculator {
    public static float calculator(float num1, float num2, char operater) {
        switch (operater) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Số chia không thể bằng 0!");
                }
        }
        return 0;
    }
}
