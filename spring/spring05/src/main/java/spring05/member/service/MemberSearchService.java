package spring05.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring05.member.dao.MemberDao;
import spring05.member.dto.Member;

public class MemberSearchService {

	@Autowired
	private MemberDao memberDao;

	public MemberSearchService() {
		
	}
	
	public Member searchMember(String mId) {
		return memberDao.select(mId);
	}
	
	public void initMethod() {
		System.out.println("멤버 검색 빈 생성");
	}
	
	public void destroyMethod() {
		System.out.println("멤버 검색 빈 파괴");
	}
}
