package spring05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring05.member.config.MemberConfig;
import spring05.member.dto.Member;
import spring05.member.service.MemberRegisterService;
import spring05.member.service.MemberSearchService;

public class MainUseConfigration {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class);
		
		MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		MemberSearchService memberSearchService = ctx.getBean("memberSearchService", MemberSearchService.class);
		
		memberRegisterService.register(new Member("1","1","1"));
		memberRegisterService.register(new Member("2","2","2"));
		memberRegisterService.register(new Member("3","3","3"));
		memberRegisterService.register(new Member("4","4","4"));
		
		 Member member = memberSearchService.searchMember("3");
		 System.out.println(member.getmId());
		 
		 ctx.close();
	}

}
