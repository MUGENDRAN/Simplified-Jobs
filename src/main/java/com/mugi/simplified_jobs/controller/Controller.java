package com.mugi.simplified_jobs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mugi.simplified_jobs.model.ClientData;
import com.mugi.simplified_jobs.service.Services;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/mugi")
@CrossOrigin(origins = "*")
public class Controller 
{
	private Services services;
	
	
	@PostMapping	
	public ResponseEntity<ClientData> addCompany(@RequestBody ClientData clientData)
	{
		return new ResponseEntity<>(services.createCompany(clientData),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientData> getCompanyById(@PathVariable("id") Long companyId)
	{
	 	ClientData clientData = services.getCompanyDetails(companyId);
	 	return ResponseEntity.ok(clientData);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientData>> getAllRequirements()
	{
		List<ClientData> requirements = services.getAllCompanysRequirements();
		return ResponseEntity.ok(requirements);
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long companyId)
	{
		String statement = services.deleteRequirementById(companyId);
		return  ResponseEntity.ok(statement);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<ClientData>> getCompaniesByName(@PathVariable("name") String companyName)
	{
		List<ClientData> requirements = services.getCompanyDetailsByName(companyName);
		return ResponseEntity.ok(requirements);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable("name") String companyName)
	{
		String message = services.deleteRequirementByName(companyName);
		return ResponseEntity.ok(message);
		
	}
	
	@PutMapping("/update/{name}")
	public ResponseEntity<List<ClientData>> updateByName(@PathVariable("name") String companyName, @RequestBody ClientData clientData)
	{
		List<ClientData> updated = services.updateByName(companyName, clientData);
		return ResponseEntity.ok(updated);
	}

}
