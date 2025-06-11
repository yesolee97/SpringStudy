package kr.or.ddit.member.service;

import kr.or.ddit.vo.MemberVO;

public interface MemberService {
	public void createMember(MemberVO member);
//	public readMemberList
	public MemberVO readMember(String username);
//	public modifyMember
//	public removeMember
}
