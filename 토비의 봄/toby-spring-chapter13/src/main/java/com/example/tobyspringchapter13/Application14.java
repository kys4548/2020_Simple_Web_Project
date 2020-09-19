package com.example.tobyspringchapter13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class Application14 {

    @RestController
    public static class MyController {

        @GetMapping("/event/{id}")
        public Mono<Event> event(@PathVariable long id) {
            return Mono.just(new Event(id, "event " + id));
        }

        @GetMapping("/monoEvents")
        public Mono<List<Event>> monoEvents() {
            List<Event> list = Arrays.asList(
                    new Event(1L, "event1"),
                    new Event(2L, "event2")
            );
            return Mono.just(list);
        }

        @GetMapping(value = "/fluxEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public Flux<Event> fluxEvents() {
             Flux<String> flux =  Flux
                     .generate(sink -> sink.next("event"));

             Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

             return Flux
                     .zip(flux, interval)
                     .map(tu -> new Event(tu.getT2(), tu.getT1()));
        }
    }

    @Data
    @AllArgsConstructor
    public static class Event {
        long id;
        String value;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application14.class, args);
    }
}
