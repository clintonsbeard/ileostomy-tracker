package com.clintonbeardsley.ileostomytracker.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NoArgsConstructor
@Table (name = "entries", schema = "ileostomy_tracker")
public class Entry {

	@Id
	@Getter
	@Setter
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "entry_id", nullable = false, unique = true)
	@Schema (name = "id", type = "Integer", description = "Primary key of entry (automatically generated).")
	private Integer id;

	@Getter
	@Setter
	@NotBlank
	@Column (name = "weight", nullable = false)
	@Schema (name = "weight", type = "String", description = "Weight at time of entry.")
	private String weight;

	@Getter
	@Setter
	@NotBlank
	@Column (name = "output", nullable = false)
	@Schema (name = "output", type = "String", description = "Output of entry (in milliliters).")
	private String output;

	@Getter
	@Setter
	@CreationTimestamp
	@Column (name = "create_timestamp", nullable = false)
	@Schema (name = "createTimestamp", type = "LocalDateTime", description = "Timestamp from when entry was first created (automatically generated).")
	private LocalDateTime createTimestamp;

	@Getter
	@Setter
	@UpdateTimestamp
	@Column (name = "last_update_timestamp", nullable = false)
	@Schema (name = "lastUpdateTimestamp", type = "LocalDateTime", description = "Timestamp from when entry was last updated (automatically generated).")
	private LocalDateTime lastUpdateTimestamp;

}