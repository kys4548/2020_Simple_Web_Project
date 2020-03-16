package spring05.member.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import spring05.member.dao.MemberDao;
import spring05.member.dto.Member;

public class MemberRegisterService implements InitializingBean, DisposableBean{

	
	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() {
		
	}
	
	public void register(Member member) {
		memberDao.insert(member);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("멤버 등록 빈 파괴");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("멤버 등록 빈 생성");
	}
	
}
