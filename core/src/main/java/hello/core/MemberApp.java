package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp { // 실행되는지 테스트

    public static void main(String[] args) { // 단축키 psvm
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // memberService 안에 memberServiceImpl이 존재한다.
        // MemberService memberService = new MemberServiceImpl();

        // SpringContainer 생성
        // Annotaition 기반 설정
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v
        memberService.join(member); // 회원가입

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        // 같으면 정상적으로 회원가입이 된것
    }
}
