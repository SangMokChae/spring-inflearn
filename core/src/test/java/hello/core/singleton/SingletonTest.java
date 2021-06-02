package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조 값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1  =/= memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    } // 각기 다른 객체를 생성해서 jvm memory 에 생성된다. // AppConfig안의 객체를 4개씩 계속 생성하는 문제가 발생한다. -> 메모리 낭비 !!

    /*
    public static void main(String[] args) {
        // 새로운 singleton을 만들 수 없다.
        SingletonService singletonService = new SingletonService();
    }
     */

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
       // new SingletonService(); // 컴파일 오류를 준다. // new 생성을 private로 막는다.

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
        // same == 객체 인스턴스가 같은것 / 참조형 비교
        // equal == equals method를 오버라이드 하는것
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void singleContainer() {

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
