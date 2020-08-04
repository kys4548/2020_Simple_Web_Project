package generics2;

public class IntersectionType2 {
    interface  Pair<T> {
        T getFirst();
        T getSecond();
        void setFirst(T first);
        void setSecond(T second);
    }

    static class Name implements Pair<String> {
        String firstName;
        String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String getFirst() {
            return firstName;
        }

        @Override
        public String getSecond() {
            return lastName;
        }

        @Override
        public void setFirst(String first) {
            this.firstName = first;
        }

        @Override
        public void setSecond(String second) {
            this.lastName = second;
        }
    }

    interface  ForwardingPair<T> extends DelegateTo<Pair<T>>, Pair<T> {
        default T getFirst() {
            return delegate().getFirst();
        }
        default T getSecond() {
            return delegate().getSecond();
        }

        default void setFirst(T first) {
            delegate().setFirst(first);
        }

        default void setSecond(T second) {
            delegate().setSecond(second);
        }
    }

    public static void main(String[] args) {

    }

    interface DelegateTo<T> {
        T delegate();
    }
}
