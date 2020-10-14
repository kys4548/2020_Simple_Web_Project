package study.datajpareview.javatest;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.stereotype.Component;

@Component
public class JavaTest {

    public void run() {

    }


    @Component
    static class HibernateProxy implements org.hibernate.proxy.HibernateProxy {
        JavaTest javaTest;

        @Override
        public Object writeReplace() {
            return null;
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {
            return null;
        }
    }

}
