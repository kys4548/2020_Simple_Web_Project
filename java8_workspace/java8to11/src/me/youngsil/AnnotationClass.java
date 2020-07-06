package me.youngsil;

import java.io.Serializable;

public class AnnotationClass {
    public static void main(String[] args) {
    }

    public static <C extends Number> void solve(C c) {
        System.out.println(c);
    }
}