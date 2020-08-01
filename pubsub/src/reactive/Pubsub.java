package reactive;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

public class Pubsub {

    public static void main(String[] args) {

        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);


        Publisher<Integer> p = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                final Iterator<Integer> it = itr.iterator();

                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        try {
                            while (n-- > 0) {
                                if (it.hasNext()) {
                                    subscriber.onNext(it.next());
                                } else {
                                    subscriber.onComplete();
                                    break;
                                }
                            }
                        }
                        catch (RuntimeException e) {
                            subscriber.onError(e);
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> s = new Subscriber<Integer>() {
            private Subscription subscription;
            private int bufferSize = 2;

            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                this.subscription = subscription;
                subscription.request(2);

            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext " + item);
                if(--bufferSize <= 0) {
                    bufferSize = 2;
                    subscription.request(2);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        p.subscribe(s);
    }
}
