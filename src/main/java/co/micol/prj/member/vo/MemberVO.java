package co.micol.prj.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String email;
	private String password;
	private String name;
	private String state;
	private String fileName;
	private String fileUuid;
	private MultipartFile multifile;		//폼에서 넘어오는 파일객체
	
	
}
