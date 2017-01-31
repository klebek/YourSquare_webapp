package rest.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserResponseDto {

	private List<UserDto> result;

	
	
	public UserResponseDto(List<UserDto> result) {
		super();
		this.result = result;
	}

	public List<UserDto> getResult() {
		return result;
	}

	public void setResult(List<UserDto> result) {
		this.result = result;
	}

	
	
	
}
