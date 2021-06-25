package co.micol.prj.member.map;

import org.apache.ibatis.annotations.Select;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMap {
	@Select("select * from member where email=#{email} and password=#{password}")
	MemberVO loginCheck(MemberVO vo);
}
