package co.micol.prj.survey.vo;

import java.util.List;

public class AnsweredData {
	private List<String> responses;
	private RespondentVO res;
	
	public List<String> getResponses() {
		return responses;
	}
	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
	public RespondentVO getRes() {
		return res;
	}
	public void setRes(RespondentVO res) {
		this.res = res;
	}
	
}
