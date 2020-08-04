import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    <T> void print(T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        new Generics().print("hello");
    }
}