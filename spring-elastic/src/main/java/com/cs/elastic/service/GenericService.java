package com.cs.elastic.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 
 * @author sanjib.pramanick
 *
 * @param <T>
 * @param <K>
 */
public interface GenericService<T, K extends Serializable> {

	Logger LOGGER = LoggerFactory.getLogger(GenericService.class.getName());

	public ElasticsearchRepository<T, K> getRepo();

	default public List<T> getAll() {
		List<T> list = new ArrayList<T>();
		try {
			getRepo().findAll().forEach(list::add);
		} catch (Exception e) {
			LOGGER.error("Exception in GenericService : ", e);
		}
		return list;
	}

	default public T getById(K id) {
		try {
			Optional<T> obj = getRepo().findById(id);
			return obj.isPresent() ? obj.get() : null;
		} catch (Exception e) {
			LOGGER.error("Exception in GenericService : ", e);
		}
		return null;
	}

	default public T save(T obj) {
		LOGGER.error("Trying to save entity : " + obj.toString());
		try {
			return getRepo().save(obj);
		} catch (Exception e) {
			LOGGER.error("Exception in GenericService : ", e);
		}
		return null;
	}

	default public T update(T obj) {
		try {
			return getRepo().save(obj);
		} catch (Exception e) {
			LOGGER.error("Exception in GenericService : ", e);
		}
		return null;
	}

	default public Boolean remove(K id) {
		try {
			if (getRepo().existsById(id)) {
				getRepo().deleteById(id);
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("Exception in GenericService : ", e);
		}
		return false;
	}

}
