package com.clintonbeardsley.ileostomytracker.repository.impl;

import com.clintonbeardsley.ileostomytracker.model.Entry;
import com.clintonbeardsley.ileostomytracker.repository.EntryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class EntryRepositoryImpl implements EntryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Entry entry) {
		entityManager.persist(entry);
	}

}