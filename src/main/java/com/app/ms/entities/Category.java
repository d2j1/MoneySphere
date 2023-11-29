package com.app.ms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(name = "title")
	private String categoryName;
	
	@Column(name="description")
	private String categoryDesc;

	


}
