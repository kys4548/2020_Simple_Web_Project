package inflearn.study.querydslreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuerydslReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslReviewApplication.class, args);
    }

}
