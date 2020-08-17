package com.pluralsight.conferencedemo.repositories;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.pluralsight.conferencedemo.models.Speaker;

public class SpeakerCustomRepositoryImpl implements SpeakerCustomRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Speaker> findAllFristName(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Speaker> criteria = cb.createQuery(Speaker.class);
		Root<Speaker> fairdOnly = criteria.from(Speaker.class);
		criteria.select(fairdOnly).where(cb.equal(fairdOnly.get("firstName"),name));
		return entityManager.createQuery(criteria).getResultList();
	}

}
