package reactor;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static reactor.core.scheduler.Schedulers.parallel;

public class DemoReactorApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {
        Flux<Long> flux = Flux.interval(Duration.ofSeconds(1))
                .map(n -> n + 1)
                .doOnNext(n -> {
                    System.out.println(n + " " + Thread.currentThread());
                }).take(2);

        Thread.sleep(5000);
        System.out.println("start");
        flux.subscribe();
        flux.subscribe();
        flux.subscribe();

        Thread.sleep(4000);

//        StepVerifier.withVirtualTime(() -> Flux.interval(Duration.ofSeconds(1)).take(Duration.ofHours(1)))
//                .thenAwait(Duration.ofHours(1))
//                .expectNextCount(3599)
//                .verifyComplete();
    }

    public static class User {

        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }


    @Test
    public void demo01() {
        Mono<Object> mono = Mono.error(new RuntimeException());
        mono.log().onErrorReturn(2)
                .doOnNext(System.out::println)
                .subscribe();
    }
}
