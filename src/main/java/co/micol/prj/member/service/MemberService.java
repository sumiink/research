package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	MemberVO loginCheck(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	List<MemberVO> memberSelectList(String state);
	MemberVO memberSelect(MemberVO vo);
}
