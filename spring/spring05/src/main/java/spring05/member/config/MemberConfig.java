package spring05.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring05.member.dao.MemberDao;
import spring05.member.service.MemberRegisterService;
import spring05.member.service.MemberSearchService;

@Configuration
public class MemberConfig {
	
	//<bean id="memberDao" class="spring05.member.dao.MemberDao"></bean>
	//<bean id="memberRegisterService" class="spring05.member.service.MemberRegisterService"></bean>
	//<bean id="memberSearchService" class="spring05.member.service.MemberSearchService"></bean>
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
	
	@Bean
	public MemberSearchService memberSearchService() {
		return new MemberSearchService();
	}
}
