package com.youngsil.spring06.member;

public class Member {

	private String mId;
	private String mPw;
	private String mName;
	
	public Member(String mId, String mPw, String mName) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	
	
}
