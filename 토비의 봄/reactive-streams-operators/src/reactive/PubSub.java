package reactive;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.Flow.*;

/**
 * Publisher -> [Data1] -> Operator -> [Data2] ->.... -> [Data] -> Subscriber
 *  데이터 흐름을 정의 (가공이 일어남)
 *  1. map ( d1 -> f -> d2)
 */

public class PubSub {

    public static void main(String[] args) {
        Publisher<Integer> pub = iterPub(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));
        Publisher<Integer> mapPub = mapPub(pub, s-> s * 10);
        Publisher<Integer> map2Pub = mapPub(mapPub, s -> s * 10);
        map2Pub.subscribe(logSub());
    }

    private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
        return new Publisher<Integer>() {

            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                pub.subscribe(new IntegerSubscriber(subscriber, f));
            }
        };
    }


    private static Subscriber<Integer> logSub() {
        return new Subscriber<Integer>() {
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
                System.out.println("onError: {}, " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete : {}");
            }
        };
    }

    private static Publisher<Integer> iterPub(List<Integer> iter) {
        return new Publisher<Integer>() {


            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        try {
                            iter.forEach(s -> subscriber.onNext(s));
                            subscriber.onComplete();
                        } catch (Throwable t) {
                            subscriber.onError(t);
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };
    }

    private static class IntegerSubscriber implements Subscriber<Integer> {

        private final Subscriber<? super Integer> subscriber;
        private final Function<Integer, Integer> f;

        public IntegerSubscriber(Subscriber<? super Integer> subscriber, Function<Integer, Integer> f) {
            this.subscriber = subscriber;
            this.f = f;
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            subscriber.onSubscribe(subscription);
        }

        @Override
        public void onNext(Integer item) {
            subscriber.onNext(f.apply(item));
        }

        @Override
        public void onError(Throwable throwable) {
            subscriber.onError(throwable);
        }

        @Override
        public void onComplete() {
            subscriber.onComplete();
        }
    }
}
