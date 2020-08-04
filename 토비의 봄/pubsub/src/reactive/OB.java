package reactive;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class OB {

    static class IntObservable extends Observable implements Runnable {
        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                setChanged();
                notifyObservers(i);
            }
        }
    }

    public static void main(String[] args) {
        Observer ob = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        final IntObservable intObservable = new IntObservable();
        intObservable.addObserver(ob);

        intObservable.run();
    }
}
