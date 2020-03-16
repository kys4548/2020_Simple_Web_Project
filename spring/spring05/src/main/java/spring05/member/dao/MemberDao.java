package spring05.member.dao;

import java.util.HashMap;
import java.util.Map;

import spring05.member.dto.Member;

public class MemberDao {

	Map<String, Member> memberDB = new HashMap<String, Member>();
	
	public void insert(Member member) {
		memberDB.put(member.getmId(), member);
	}
	
	public Member select(String mId) {
		return memberDB.get(mId);
	}
	
	public Map<String, Member> getMemberDB() {
		return memberDB;
	}
}
