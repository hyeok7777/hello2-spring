package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        // ThreadA : A 10000 주문
        statefulService.order("userA", 10000);
        // ThreadB : B 20000 주문
        statefulService1.order("userB", 20000);

        // ThreadA : A 주문 금액 조회
        System.out.println("statefulService1.getPrice() = " + statefulService1.getPrice());
        // ThreadB : B 주문 금액 조회
        System.out.println("statefulService.getPrice()x` = " + statefulService.getPrice());

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}