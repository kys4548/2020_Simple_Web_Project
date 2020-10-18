package inflearn.study.querydslreview;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableJpaAuditing
public class QuerydslReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslReviewApplication.class, args);
    }
}
