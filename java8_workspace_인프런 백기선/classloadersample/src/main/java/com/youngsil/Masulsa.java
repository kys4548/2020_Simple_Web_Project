package com.youngsil;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args) throws IOException {



//        final ClassLoader classLoader = Masulsa.class.getClassLoader();
//        final TypePool typePool = TypePool.Default.of(classLoader);
//        new ByteBuddy()
//                .redefine(
//                        typePool.describe("com.youngsil.Moja").resolve(),
//                        ClassFileLocator.ForClassLoader.of(classLoader)
//                )
//                .method(named("pullOut"))
//                .intercept(FixedValue.value("Rabbit"))
//                .make().saveIn(new File("C:\\Users\\a\\Desktop\\study\\2020_Simple_Web_Project\\java8_workspace_인프런 백기선\\classloadersample\\target\\classes"));


//                new ByteBuddy().redefine(Moja.class)
//                .method(named("pullOut")).intercept(FixedValue.value("Rabiit!"))
//                .make().saveIn(new File("C:\\Users\\a\\Desktop\\study\\2020_Simple_Web_Project\\java8_workspace_인프런 백기선\\classloadersample\\target\\classes"));


        System.out.println(new Moja().pullOut());
    }
}
