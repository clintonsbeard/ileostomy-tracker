package com.clintonbeardsley.ileostomytracker.service.impl;

import com.clintonbeardsley.ileostomytracker.model.Entry;
import com.clintonbeardsley.ileostomytracker.repository.EntryRepository;
import com.clintonbeardsley.ileostomytracker.service.EntryService;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {

	private final EntryRepository entryRepository;

	@Override
	public void create(Entry entry) {
		entryRepository.create(entry);
	}

}