package com.mugi.simplified_jobs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {
	
	private long id;
	private String name;
	private float percentage;
	private long freshness;
	private List<String> location;
	private String link;

}
