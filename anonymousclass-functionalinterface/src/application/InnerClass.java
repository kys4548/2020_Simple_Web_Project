package application;

import java.util.function.IntBinaryOperator;

public class InnerClass {
    public static void main(String[] args) {
        IntBinaryOperator add = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        };
    }
}
