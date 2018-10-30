package com.cs.elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@Document(indexName = "demopersonindex", type = "persons")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Person {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;

}
