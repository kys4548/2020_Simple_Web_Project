package com.example.youngsil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 타입을 강제로 변환시키는 행위는 위험하다.
 * 상황이 정말 확실하지 않을때 위험
 * ex)
 * Map<String, Object> map = new HashMap<>();
 * int i = (int) map.get("a");
 *
 */
public class TypeToken {
    static class TypeSafeMap {
        //클래스 단위에서 특정 타입하나에 일치하는 상황이 아닐때 와일드 카드 사용
        Map<Class<?>, Object> map  = new HashMap<>();

        <T> void put(Class<T> clazz, T value) {
            map.put(clazz, value);
        }

        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
        }
    }

    public static void main(String[] args) {
        TypeSafeMap typeSafeMap = new TypeSafeMap();
        typeSafeMap.put(Integer.class, 1);
        typeSafeMap.put(String.class, "String");
        typeSafeMap.put(List.class, Arrays.asList(1,2,3));
        typeSafeMap.put(List.class, Arrays.asList("a", "b", "c"));

        System.out.println(typeSafeMap.get(Integer.class));
        System.out.println(typeSafeMap.get(String.class));
        System.out.println(typeSafeMap.get(List.class));
    }
}
