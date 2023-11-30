package com.app.ms.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	
	private Integer categoryId;	
	
	@NotBlank
	@Size(min =2)
	private String categoryName;
	
	@NotBlank
	private String categoryDesc;
}
