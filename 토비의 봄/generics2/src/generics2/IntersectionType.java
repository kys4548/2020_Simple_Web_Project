package generics2;

import java.util.function.Consumer;

public class IntersectionType {
    interface DelegateTo<T> {
        T delegate();
    }

    interface Hello extends  DelegateTo<String> {
        default void hello() {
            System.out.println("Hello " + delegate());
        }
    }

    public static void main(String[] args) {
        run((DelegateTo<String> & Hello)() -> "Youngsil Kim", o -> {
            o.hello();
        });
    }

    private static <T extends DelegateTo<S>, S>void run(T t, Consumer<T> consumer) {
        consumer.accept(t);

    }
}
