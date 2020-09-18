package com.example.youngsil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

import static java.util.concurrent.Flow.*;

public class PubSub {
    public static void main(String[] args) {
        Publisher<Integer> pub = iterPub();
        Publisher<Integer> mapPub = mapPub(pub,  s -> s * 10);
        mapPub.subscribe(logSub());

    }

    private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                pub.subscribe(new Subscriber<Integer>() {
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
                });
            }
        };
    }

    private static Subscriber<Integer> logSub() {
        return new Subscriber<Integer>() {
                Subscription subscription;

                @Override
                public void onSubscribe(Subscription subscription) {
                    this.subscription = subscription;
                    subscription.request(1);
                }

                @Override
                public void onNext(Integer item) {
                    System.out.println(item);
                    subscription.request(1);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("onError");
                }

                @Override
                public void onComplete() {
                    System.out.println("complete");
                }
            };
    }

    private static Publisher<Integer> iterPub() {
        Iterable<Integer> iterable = Arrays.asList(1,2,3,4,5);

        return new Publisher<Integer>() {
            Iterator<Integer> iterator = iterable.iterator();

            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        try {
                            while (n-- > 0) {
                                if (iterator.hasNext()) {
                                    subscriber.onNext(iterator.next());
                                } else {
                                    subscriber.onComplete();
                                    break;
                                }
                            }
                        } catch (RuntimeException e) {
                            subscriber.onError(e);
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };
    }
}
