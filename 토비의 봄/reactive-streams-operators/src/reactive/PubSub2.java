package reactive;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

public class PubSub2 {
    public static void main(String[] args) {
        Publisher<Integer> pub = subscriber -> {
            subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    subscriber.onNext(1);
                    subscriber.onNext(2);
                    subscriber.onNext(3);
                    subscriber.onNext(4);
                    subscriber.onNext(5);
                    subscriber.onComplete();
                }

                @Override
                public void cancel() {

                }
            });
        };

        Publisher<Integer> subOnPub = subscriber -> {
            ExecutorService es = Executors.newSingleThreadScheduledExecutor();
            es.execute(() -> pub.subscribe(subscriber));
        };


        Publisher<Integer> pubOnPub = subscriber -> {
            subOnPub.subscribe(new Subscriber<Integer>() {
                ExecutorService es = Executors.newSingleThreadExecutor();
                @Override
                public void onSubscribe(Subscription subscription) {
                    subscriber.onSubscribe(subscription);
                }

                @Override
                public void onNext(Integer item) {
                    es.execute(() -> subscriber.onNext(item));
                }

                @Override
                public void onError(Throwable throwable) {
                    es.execute(() ->subscriber.onError(throwable));
                }

                @Override
                public void onComplete() {
                    es.execute(() ->subscriber.onComplete());
                }
            });
        };



        pubOnPub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext : " + item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
        System.out.println("main exit");
    }
}
