package com.clintonbeardsley.ileostomytracker.controller;

import com.clintonbeardsley.ileostomytracker.model.Entry;
import com.clintonbeardsley.ileostomytracker.service.EntryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.exception.SQLGrammarException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag (name = "Entry API")
@RequestMapping ("/entry")
public class EntryController {

	private final EntryService entryService;

	/**
	 * API endpoint for creating a new entry in the database.
	 *
	 * @param entry Entry to be persisted in the database.
	 * @return Entry after being persisted in the database with new primary key attached.
	 */

	@PostMapping ("/create")
	@Operation (summary = "Create new entry and persist them in the database.")
	@ApiResponses ({
		@ApiResponse (responseCode = "201",
			description = "Entry successfully created.",
			content = @Content (mediaType = "application/json", schema = @Schema (implementation = Entry.class))
		),
		@ApiResponse (responseCode = "500",
			description = "Failure creating entry due to server error.",
			content = @Content (mediaType = "application/json", schema = @Schema (implementation = Entry.class))
		)
	})
	public ResponseEntity<Entry> createManufacturers(@Valid @RequestBody Entry entry) {
		try {
			log.info("ManufacturerController.createManufacturers() - Method Entry");
			entryService.create(entry);
			log.info("ManufacturerController.createManufacturers() - Method Exit");
			return new ResponseEntity<>(entry, HttpStatus.CREATED);
		}
		catch (SQLGrammarException ex) {
			log.error("SQLGrammarException - {}", ex.getLocalizedMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Encountered an error attempting to persist entry in the database.", ex);
		}
	}

}