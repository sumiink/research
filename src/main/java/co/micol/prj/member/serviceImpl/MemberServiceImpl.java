package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.member.map.MemberMap;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;
@Repository("memberDao")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMap map;
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return map.loginCheck(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public List<MemberVO> memberSelectList(String state) {
		return map.memberSelectList(state);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

}
