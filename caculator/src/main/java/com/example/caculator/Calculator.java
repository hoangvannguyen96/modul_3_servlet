package com.example.caculator;

public class Calculator {
    public static float calculator(float num1, float num2, char operator) {
        switch (operator) {
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
                    throw new RuntimeException("số chia không thể bằng 0");
                }
        }
        return 0;
    }
}
