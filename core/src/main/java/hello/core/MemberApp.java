package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig =new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // MemberService memberService = new MemberServiceImpl();

      //이제 스프링 컨테이너를 통해서 찾아온다.
        //골뱅이 붙은 것을 다 관리해준다
        //AppConfig에 있는 환경 설정 정보를 가지고
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig에서 memberService를 꺼낼 것이다. (기본적으로 메서드 이름으로 등록되어 있다.)  , 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

       Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " +member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
