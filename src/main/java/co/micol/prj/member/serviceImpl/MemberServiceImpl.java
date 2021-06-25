package co.micol.prj.member.serviceImpl;

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

}
