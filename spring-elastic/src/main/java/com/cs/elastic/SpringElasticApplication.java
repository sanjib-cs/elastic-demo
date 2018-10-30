package com.cs.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cs.elastic.model.Book;
import com.cs.elastic.service.BookService;
import com.cs.elastic.utill.ElasticUtil;

@SpringBootApplication(exclude = { ElasticsearchDataAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class SpringElasticApplication implements CommandLineRunner {

	@Autowired
	private ElasticUtil util;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		util.printElasticSearchInfo();

		bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
		bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

		// fuzzey search
		Page<Book> books = bookService.findByAuthor("Rambabu", PageRequest.of(0, 10));

		// List<Book> books = bookService.findByTitle("Elasticsearch Basics");

		books.forEach(x -> System.out.println(x));

	}
}
