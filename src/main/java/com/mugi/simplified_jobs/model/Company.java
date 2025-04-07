package com.mugi.simplified_jobs.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "company_name")
	private String name;
	@Column(name = "company_percentage")
	private float percentage;
	@Column(name = "post_freshness")
	private long freshness;
	@Column(name = "company_location")
	private List<String> location;
	@Column(name = "offical_link")
	private String link;
}
