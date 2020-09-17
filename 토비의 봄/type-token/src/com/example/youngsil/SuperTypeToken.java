package com.example.youngsil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class SuperTypeToken {

    static class TypeSafeMap {
        Map<TypeReference<?>, Object> map = new HashMap<>();

        <T> void put(TypeReference<T> tr, T value) {
            map.put(tr, value);
        }

        <T> T get(TypeReference<T> tr) {
            return ((Class<T>)tr.type).cast(map.get(tr));
        }
    }

    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type pType = this.getClass().getGenericSuperclass();
            if(pType instanceof ParameterizedType) {
                type = ((ParameterizedType)pType).getActualTypeArguments()[0];
            } else {
                throw new RuntimeException();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TypeReference<?> that = (TypeReference<?>) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }

    public static void main(String[] args) {
        TypeSafeMap m = new TypeSafeMap();
        m.put(new TypeReference<String>(){}, "String");
        m.put(new TypeReference<Integer>(){}, 1);
        m.put(new TypeReference<List<Integer>>(){}, Arrays.asList(1,2,3));

        System.out.println(m.get(new TypeReference<String>(){}));
    }
}
