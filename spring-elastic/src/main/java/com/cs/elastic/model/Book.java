package com.cs.elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "demobookindex", type = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Book {

	@Id
	private String id;

	private String title;

	private String author;

	private String releaseDate;

}
