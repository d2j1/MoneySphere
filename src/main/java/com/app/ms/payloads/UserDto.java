package com.app.ms.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=4, message = "User name must not blank and has min length 4")
	private String name;
	
	@Email(message="Email address is not valid")
	private String email;
	
	@NotEmpty(message= "password should not blank")
	@Size(min=3,max=9, message = "password must be min 3 and max 9 size")
	private String password;
	
	@NotEmpty(message="About should not be empty")
	private String about;
	
	
}
