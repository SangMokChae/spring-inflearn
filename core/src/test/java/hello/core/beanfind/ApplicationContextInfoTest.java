package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    // Spring Container 생성
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() { // junit5부터 public 생략 가능

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) { // iter + tab for문이 자동완성된다.
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " +beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() { // junit5부터 public 생략 가능

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) { // iter + tab for문이 자동완성된다.
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // bean 하나하나에 대한..

            // role이 스프링 내부의 bean이 아닌 내가 쓴 / 외부라이브러리 빈만 출력해주는 것
            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " +beanDefinitionName + " object = " +bean);
            }
        }
    }

}
