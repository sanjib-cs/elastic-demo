package com.cs.elastic.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.cs.elastic.model.Person;

/**
 * 
 * @author sanjib.pramanick
 *
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String>{

}
