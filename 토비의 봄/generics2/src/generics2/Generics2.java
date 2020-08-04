package generics2;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class Generics2 {

    interface Hello {

        default void hello() {
            System.out.println("Hello");
        }
    }

    interface  Hi {
        default void hi() {
            System.out.println("Hi");
        }
    }

    interface Printer {
        default  void print(String str) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        run((Function & Hello & Hi & Printer)s -> s, o -> {
            o.hello();
            o.hi();
            o.print("lambda");
        });
    }

    private static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
        System.out.println(t.apply("test"));
    }

}
