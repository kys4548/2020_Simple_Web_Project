package com.example.springboot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    BookService bookService;
    // bookService에서 @PostConstruct로 빈생성전 메소드 실행, @Scope로 싱글톤 지정
    // testBookRepository를 @Primary로 가장 우선순위가 빠르게 지정했지만
    // bookService에서 youngsilBookRepository를 @Qualifier로 주입받고 있다.

    @Autowired(required =  false)
    ProfileBookService profileBookService;
    //해당 bean은 @Profile("test")를 주어 test환경에서만 사용가능한 빈이므로 에러가 발생하지만
    //required = false 옵션을 주어 오류가 나지 않는다.

    @Autowired
    Environment environment;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(bookService.bookRepository.getClass());

        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        //설정에서 test Profile을 지정해줌

        System.out.println(environment.getProperty("app.about"));
        //Properties를 읽어오려면 @PropertySource를 해주어야 한다.
        //main함수에서 지정해둠

        System.out.println(messageSource.getMessage("greeting", new String[] {"영실"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting",new String[] {"youngsil"}, Locale.ENGLISH));

        applicationEventPublisher.publishEvent(new MyEvent(100,"new data"));

        Resource resource1 = resourceLoader.getResource("classpath:/test1.txt");
        Resource resource2 = resourceLoader.getResource("classpath:/test2.txt");

        System.out.println(resource1.exists());
        System.out.println(resource2.exists());
        System.out.println(resource2.getDescription());

    }
}
