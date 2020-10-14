package application;

import java.util.function.IntBinaryOperator;

public class Lambda {
    public static void main(String[] args) {
        IntBinaryOperator add = (a,b) -> a+b;
    }
}
